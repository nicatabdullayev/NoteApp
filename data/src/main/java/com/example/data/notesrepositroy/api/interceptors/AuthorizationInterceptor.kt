package com.abbtech.data.api.interceptors

import com.abbtech.data.api.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader(AUTHORIZATION_KEY, "Bearer ${SessionManager.authToken}")
        return chain.proceed(request.build())
    }

    companion object {
        private const val AUTHORIZATION_KEY = "Authorization"
    }
}