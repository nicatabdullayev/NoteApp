package com.example.data.notesrepositroy.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room

object DatabaseManager {

    lateinit var database: AppDataBase
    fun initDatabase(context: Context){

         database = Room.databaseBuilder(
            context,
            AppDataBase::class.java, "notes-db "
        ).build()

    }

}