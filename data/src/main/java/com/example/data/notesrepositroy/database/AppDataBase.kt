package com.example.data.notesrepositroy.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.notesrepositroy.dao.NotesDao
import com.example.domain.entity.entity.MyDataNote

@Database(entities = [MyDataNote::class], version = 1)
abstract class AppDataBase : RoomDatabase(){

    abstract fun notesDao():NotesDao
}