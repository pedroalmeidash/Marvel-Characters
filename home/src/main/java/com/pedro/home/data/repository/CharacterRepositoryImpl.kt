package com.pedro.home.data.repository

import com.pedro.home.data.datasource.CharacterDataSource
import com.pedro.home.data.mapper.CharacterMapper
import com.pedro.home.domain.model.Character
import com.pedro.home.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class CharacterRepositoryImpl(
    private val characterDataSource: CharacterDataSource,
    private val characterMapper: CharacterMapper
) : CharacterRepository {
    override fun getCharacters(): Flow<List<Character>> {
        return characterDataSource.getCharacters()
            .map { it.data.results }
            .map { it.map { characterResponse -> characterMapper.map(characterResponse) } }
    }
}