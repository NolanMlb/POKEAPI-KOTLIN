package com.nextu.pokedex.model.pokemon.sprite.generation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationISprites(
    @SerialName("red-blue")
    val red_blue: GenerationIDefault,
    val yellow: GenerationIDefault
)

@Serializable
data class GenerationIDefault (
    val front_default: String? = null,
    val front_gray: String? = null,
    val back_default: String? = null,
    val back_gray: String? = null,
    val back_transparent: String? = null,
    val front_transparent: String? = null
)