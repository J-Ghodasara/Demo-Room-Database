package com.example.jayghodasara.module7

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Table::class),version = 1)
abstract class Mydatabase : RoomDatabase() {


    abstract fun myDao():MyDao

}