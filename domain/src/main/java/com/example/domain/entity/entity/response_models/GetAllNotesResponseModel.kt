package com.abbtech.domain.entities.response_models

import com.google.gson.annotations.SerializedName


data class GetAllNotesResponseModel(
    @SerializedName("notes")
    val notes: List<NoteResponseModel>
)

data class NoteResponseModel(
    @SerializedName("id")
    val id: Long,
    @SerializedName("creation_date")
    val creationDate: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("sub_title")
    val subTitle: String
)