package com.pedro.remotedata.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

private const val API_KEY_PARAMETER = "apikey"
private const val HASH_KEY_PARAMETER = "hash"
private const val TIMESTAMP_KEY_PARAMETER = "ts"
private const val API_KEY_VALUE = "238f74776dd04b9d040eaf24307ede92"
private const val HASH_KEY_VALUE = "0d03007b1caaaedafd42fc5730c4b46c"
private const val TIMESTAMP_KEY_VALUE = "1919009915"

internal class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val currentRequest = chain.request()
        val newRequest = buildNewRequestWithAuth(currentRequest)
        return chain.proceed(newRequest)
    }

    private fun buildNewRequestWithAuth(request: Request): Request {
        val requestUrlBuilder = request.url.newBuilder()
        val newRequestUrl = requestUrlBuilder
            .addQueryParameter(API_KEY_PARAMETER, API_KEY_VALUE)
            .addQueryParameter(HASH_KEY_PARAMETER, HASH_KEY_VALUE)
            .addQueryParameter(TIMESTAMP_KEY_PARAMETER, TIMESTAMP_KEY_VALUE)
            .build()
        return request.newBuilder().url(newRequestUrl).build()
    }
}