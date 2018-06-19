package com.example.jayghodasara.module7

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "Mytable")
 class Table{

   @PrimaryKey(autoGenerate = true)
    var id:Int?= null

    @ColumnInfo(name="Name")
    var name:String?=null

    @ColumnInfo(name="Date")
    var Date:String?=null




}