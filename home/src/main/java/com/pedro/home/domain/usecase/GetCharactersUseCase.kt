package com.pedro.home.domain.usecase

import com.pedro.home.domain.model.Character
import com.pedro.home.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

internal class GetCharactersUseCase(
    private val characterRepository: CharacterRepository
) {
    operator fun invoke(): Flow<List<Character>> {
        return characterRepository.getCharacters()
    }
}