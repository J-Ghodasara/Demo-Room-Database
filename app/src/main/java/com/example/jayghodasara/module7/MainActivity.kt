package com.example.jayghodasara.module7


import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {

    companion object {
        public lateinit var fm: FragmentManager
        var insertfragment:Insertfragment = Insertfragment()
        var listfragment:Listfragment = Listfragment()
        lateinit var mydb:Mydatabase

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

       mydb=Room.databaseBuilder(applicationContext,Mydatabase::class.java,"Database").allowMainThreadQueries().build()


        fm =supportFragmentManager
        fm.beginTransaction().replace(R.id.frame, listfragment).addToBackStack(null).commit()

        fab.setOnClickListener { view ->
            fm =supportFragmentManager
            fm.beginTransaction().replace(R.id.frame,insertfragment).addToBackStack(null).commit()
               }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}
