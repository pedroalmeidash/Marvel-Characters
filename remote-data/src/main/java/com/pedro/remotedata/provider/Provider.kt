package com.pedro.remotedata.provider

interface Provider<out T> {
    fun provide(): T
}