package com.example.jayghodasara.module7


import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_insertfragment.*
import android.app.DatePickerDialog
import android.support.design.widget.FloatingActionButton
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.*
import java.text.SimpleDateFormat


class Insertfragment : DialogFragment(),View.OnClickListener {

    var listfragment:Listfragment= Listfragment()

    var myCalendar = Calendar.getInstance()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var v:View=inflater.inflate(R.layout.fragment_insertfragment, container, false)

        var insert:Button=v.findViewById(R.id.insert)
        var date:TextView=v.findViewById(R.id.date)

        insert.setOnClickListener(this)
        date.setOnClickListener(this)





        return v
    }

    var datee: DatePickerDialog.OnDateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

        myCalendar.set(Calendar.YEAR, year)
        myCalendar.set(Calendar.MONTH, monthOfYear)
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        updateLabel()
    }


    override fun onClick(v: View?) {
        when(v){

            insert ->{

                 var username= Name.text.toString()
                var userdate=date.text.toString()
                var tbl:Table = Table()
                tbl.name=username
                tbl.Date=userdate
                MainActivity.mydb.myDao().adduser(tbl)
                Toast.makeText(context,"Inserted Successfully",Toast.LENGTH_LONG).show()

       MainActivity.fm.beginTransaction().replace(R.id.frame,listfragment).addToBackStack(null).commit()
            }

            date ->{

              var dp:DatePickerDialog=  DatePickerDialog(context, datee, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH))
                dp.show()


            }
        }
    }


    private fun updateLabel() {
        val myFormat = "MM/dd/yy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)

        date.text = sdf.format(myCalendar.time)
    }


}
