package com.pedro.home.domain.repository

import com.pedro.home.domain.model.Character
import kotlinx.coroutines.flow.Flow

internal interface CharacterRepository {
    fun getCharacters(): Flow<List<Character>>
}