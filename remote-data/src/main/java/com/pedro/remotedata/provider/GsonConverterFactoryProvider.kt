package com.pedro.remotedata.provider

import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

internal class GsonConverterFactoryProvider : Provider<Converter.Factory> {
    override fun provide(): Converter.Factory = GsonConverterFactory.create()
}