package com.pedro.home.data.model.characters

internal data class CharacterResponse(
    val id: Long,
    val name: String,
    val description: String,
    val thumbnail: CharacterImageResponse
)