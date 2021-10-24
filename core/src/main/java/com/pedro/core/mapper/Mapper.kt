package com.pedro.core.mapper

interface Mapper<T, R> {
    fun map(from: T): R
}