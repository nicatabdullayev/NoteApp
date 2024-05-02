package com.abbtech.data.api

import com.abbtech.domain.entities.request_models.NoteRequestModel
import com.abbtech.domain.entities.response_models.GetAllNotesResponseModel
import com.abbtech.domain.entities.response_models.NoteResponseModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface NotesService {

    @GET("/get_notes")
    suspend fun getAllNotes(): List<NoteResponseModel>

    @POST("/add_note")
    suspend fun addNote(
        @Body noteRequestModel: NoteRequestModel,
    )

}