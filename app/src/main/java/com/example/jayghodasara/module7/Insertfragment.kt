package com.example.jayghodasara.module7


import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_insertfragment.*
import android.app.DatePickerDialog
import android.support.design.widget.FloatingActionButton
import android.text.Editable
import android.widget.*
import java.util.*
import java.text.SimpleDateFormat


open class Insertfragment : DialogFragment(),View.OnClickListener {

    var listfragment= Listfragment()

    var myCalendar = Calendar.getInstance()
    lateinit var idofuser:String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
            return inflater.inflate(R.layout.fragment_insertfragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context, "oncreateview called", Toast.LENGTH_LONG).show()
        insert.setOnClickListener(this)
        date.setOnClickListener(this)


        var name: String = arguments!!.getString("KEY_1",null)
        var bundle_date: String= arguments!!.getString("KEY_2",null)
        var btn_text:String=arguments!!.getString("KEY_3",null)
        idofuser=arguments!!.getString("KEY_4",null)

        insert.text = btn_text

       Name.setText(name)
        date.text=bundle_date
    }

    var datee: DatePickerDialog.OnDateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

        myCalendar.set(Calendar.YEAR, year)
        myCalendar.set(Calendar.MONTH, monthOfYear)
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        updateLabel()
    }


    override fun onClick(v: View?) {
        when(v){

            insert -> {
                if (insert.text == "INSERT") {
                    var username = Name.text.toString()
                    var userdate = date.text.toString()
                    var tbl: Table = Table()
                    tbl.name = username
                    tbl.Date = userdate
                    MainActivity.mydb.myDao().adduser(tbl)
                    Toast.makeText(context, "Inserted Successfully", Toast.LENGTH_LONG).show()

                    MainActivity.fm.beginTransaction().replace(R.id.frame, listfragment).addToBackStack(null).commit()
                }else{
                    if(insert.text=="UPDATE"){
                        var username = Name.text.toString()
                        var userdate = date.text.toString()
                        var tbl: Table = Table()
                        tbl.name = username
                        tbl.id=idofuser.toInt()
                        tbl.Date = userdate
                        MainActivity.mydb.myDao().update(tbl)
                        Toast.makeText(context, "Updated Successfully", Toast.LENGTH_LONG).show()

                        MainActivity.fm.beginTransaction().replace(R.id.frame, listfragment).addToBackStack(null).commit()

                    }
                }
            }

            date ->{

              var dp:DatePickerDialog=  DatePickerDialog(context, datee, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH))
                dp.show()


            }
        }
    }

//    public fun comm( name:String, dat: String){
//
//       Name.setText(name)
//        date.text=dat
//
//    }

    private fun updateLabel() {
        val myFormat = "MM/dd/yy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)

        date.text = sdf.format(myCalendar.time)
    }


}
