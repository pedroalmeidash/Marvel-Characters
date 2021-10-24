package com.pedro.home.data.datasource

import com.pedro.home.data.model.characters.CharactersResultWrapperResponse
import kotlinx.coroutines.flow.Flow

internal interface CharacterDataSource {
    fun getCharacters(): Flow<CharactersResultWrapperResponse>
}