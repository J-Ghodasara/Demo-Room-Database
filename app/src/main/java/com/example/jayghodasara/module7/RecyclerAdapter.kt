package com.example.jayghodasara.module7

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RecyclerAdapter(var context: Context,var list:List<Table>): RecyclerView.Adapter<RecyclerAdapter.viewHolder>(){

    var listfragment:Listfragment= Listfragment()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var V:View=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)


        return viewHolder(V)

    }

    override fun getItemCount(): Int {

     return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

           var tbl:Table=list[position]
           var nameofuser=tbl.name
           var idofuser=tbl.id
           var dateofuser=tbl.Date

        var table:Table= Table()
        table.id=idofuser
        table.name=nameofuser
        table.Date=dateofuser

          holder.id.text=idofuser.toString()
        holder.userName.text=nameofuser.toString()
        holder.Date.text=dateofuser.toString()
        holder.btn.setOnClickListener(View.OnClickListener {
            MainActivity.mydb.myDao().deleteuser(table)
            MainActivity.fm.beginTransaction().replace(R.id.frame,listfragment).commit()
            Toast.makeText(context,"Deleted Successfully",Toast.LENGTH_LONG).show()
        })

          }


    inner class viewHolder(view:View) : RecyclerView.ViewHolder(view){

        var id:TextView=view.findViewById(R.id.tv_id)
        var userName:TextView= view.findViewById(R.id.tv_name)
        var Date:TextView= view.findViewById(R.id.tv_date)
        var btn:Button= view.findViewById(R.id.btn_delete)
    }
}