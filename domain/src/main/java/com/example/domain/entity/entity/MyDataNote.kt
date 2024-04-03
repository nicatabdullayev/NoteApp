package com.example.domain.entity.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class MyDataNote (
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("subtitle")
    val subtitle : String,
    @ColumnInfo("creationDate")
    val creationDate : Long,
    @ColumnInfo("id")
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0
)