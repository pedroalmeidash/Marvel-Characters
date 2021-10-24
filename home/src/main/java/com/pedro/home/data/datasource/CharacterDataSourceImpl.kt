package com.pedro.home.data.datasource

import com.pedro.home.data.model.characters.CharactersResultWrapperResponse
import com.pedro.home.data.service.CharacterService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class CharacterDataSourceImpl(
    private val characterService: CharacterService
) : CharacterDataSource {
    override fun getCharacters(): Flow<CharactersResultWrapperResponse> = flow {
        val charactersResponse = characterService.getCharacters()
        emit(charactersResponse)
    }
}