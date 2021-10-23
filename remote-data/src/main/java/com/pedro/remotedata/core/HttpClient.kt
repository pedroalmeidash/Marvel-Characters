package com.pedro.remotedata.core

interface HttpClient {
    fun <T> create(clazz: Class<T>): T
}