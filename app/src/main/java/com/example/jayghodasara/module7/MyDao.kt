package com.example.jayghodasara.module7

import android.arch.persistence.room.*

@Dao
interface MyDao{

    @Insert
    fun adduser(table: Table)

    @Delete
    fun deleteuser(table: Table)

    @Update
    fun updateuser(table: Table)

     @Query("select * from Mytable")
    fun getusers():List<Table>

    @Update
    fun update(table: Table)
}