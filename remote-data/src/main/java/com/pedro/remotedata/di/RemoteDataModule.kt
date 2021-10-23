package com.pedro.remotedata.di

import com.pedro.remotedata.core.HttpClient
import com.pedro.remotedata.core.HttpClientImpl
import com.pedro.remotedata.provider.GsonConverterFactoryProvider
import com.pedro.remotedata.provider.InterceptorsProvider
import com.pedro.remotedata.provider.OkHttpClientProvider
import com.pedro.remotedata.provider.RetrofitProvider
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object RemoteDataModule {
    private val coreModule = module {
        single<HttpClient> { HttpClientImpl(retrofit = get()) }
    }

    private val providerModule = module {
        single { GsonConverterFactoryProvider().provide() }
        single { OkHttpClientProvider(interceptors = get()) }
        single { InterceptorsProvider().provide() }
        single { RetrofitProvider(okHttpClient = get(), converterFactory = get()).provide() }
    }

    fun load() {
        loadKoinModules(
            listOf(
                coreModule,
                providerModule
            )
        )
    }
}