package com.pedro.remotedata.provider

import okhttp3.Interceptor
import okhttp3.OkHttpClient

internal class OkHttpClientProvider(
    private val interceptors: List<Interceptor>
) : Provider<OkHttpClient> {
    override fun provide(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptors()
            .build()
    }

    private fun OkHttpClient.Builder.addInterceptors(): OkHttpClient.Builder {
        interceptors.forEach { addInterceptor(it) }
        return this
    }
}