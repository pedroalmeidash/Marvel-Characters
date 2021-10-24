package com.pedro.home.data.mapper

import com.pedro.core.mapper.Mapper
import com.pedro.home.data.model.characters.CharacterResponse
import com.pedro.home.domain.model.Character

internal class CharacterMapper : Mapper<CharacterResponse, Character> {
    override fun map(from: CharacterResponse): Character = with(from) {
        return Character(
            id = id,
            name = name,
            description = description,
            imageUrl = thumbnail.formatImageUrl()
        )
    }
}