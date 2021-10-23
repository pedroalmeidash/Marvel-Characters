package com.pedro.remotedata.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

private const val API_KEY_PARAMETER = "apikey"
private const val API_KEY_VALUE = "238f74776dd04b9d040eaf24307ede92"

internal class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val currentRequest = chain.request()
        val newRequest = buildNewRequestWithApiKey(currentRequest)
        return chain.proceed(newRequest)
    }

    private fun buildNewRequestWithApiKey(request: Request): Request {
        val requestUrlBuilder = request.url.newBuilder()
        val newRequestUrl = requestUrlBuilder
            .addQueryParameter(API_KEY_PARAMETER, API_KEY_VALUE)
            .build()
        return request.newBuilder().url(newRequestUrl).build()
    }
}