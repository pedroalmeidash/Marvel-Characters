package com.pedro.home.data.service

import com.pedro.home.data.model.characters.CharactersResultWrapperResponse
import retrofit2.http.GET

internal interface CharacterService {
    @GET("characters")
    suspend fun getCharacters(): CharactersResultWrapperResponse
}