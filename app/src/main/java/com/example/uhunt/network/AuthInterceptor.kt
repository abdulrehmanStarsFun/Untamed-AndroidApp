package com.davidorellana.logincomposeretrofit2.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val serverKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("server-key", serverKey)
            .build()

        return chain.proceed(request)
    }
}
