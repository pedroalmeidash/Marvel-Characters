package com.pedro.remotedata.provider

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

private const val BASE_URL = "https://gateway.marvel.com/v1/public/"

internal class RetrofitProvider(
    private val okHttpClient: OkHttpClient,
    private val converterFactory: Converter.Factory
) : Provider<Retrofit> {
    override fun provide(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }
}