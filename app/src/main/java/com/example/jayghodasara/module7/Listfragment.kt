package com.example.jayghodasara.module7


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import kotlinx.android.synthetic.main.fragment_listfragment.*
import kotlinx.android.synthetic.main.list_item.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Listfragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var V:View= inflater.inflate(R.layout.fragment_listfragment, container, false)
       var list:RecyclerView=V.findViewById(R.id.list)
       var array:List<Table> =  MainActivity.mydb.myDao().getusers()
        var layman=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        var recyclerAdapter= RecyclerAdapter(context!!,array)


        list.adapter=recyclerAdapter
        list.layoutManager=layman




        return V
    }




}
