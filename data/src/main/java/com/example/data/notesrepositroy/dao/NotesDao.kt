package com.example.data.notesrepositroy.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.domain.entity.entity.MyDataNote
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Insert
    fun insert(note:MyDataNote)

    @Delete
    fun delete(note:MyDataNote)

    @Update
    fun update(note:MyDataNote)

    @Query("SELECT * FROM notes")
    fun getAll() : Flow<List<MyDataNote >>
}