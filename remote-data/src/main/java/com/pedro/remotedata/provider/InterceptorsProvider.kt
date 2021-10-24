package com.pedro.remotedata.provider

import com.pedro.remotedata.interceptor.AuthInterceptor
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

internal class InterceptorsProvider : Provider<List<Interceptor>> {
    override fun provide(): List<Interceptor> {
        return listOf(
            AuthInterceptor(),
            getHttpLoggingInterceptor()
        )
    }

    private fun getHttpLoggingInterceptor(): Interceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }
}