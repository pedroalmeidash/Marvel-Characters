package com.pedro.home.data.model.characters

private const val IMAGE_SEPARATOR = "."

internal data class CharacterImageResponse(
    val path: String,
    val extension: String
) {
    fun formatImageUrl(): String {
        return path.plus(IMAGE_SEPARATOR).plus(extension)
    }
}