package com.abbtech.domain.entities.remote

import java.lang.Exception

sealed class ResultWrapper {

    data class Success<T>(val value: T) : ResultWrapper()

    data class Error(val exception: Exception) : ResultWrapper()

}
