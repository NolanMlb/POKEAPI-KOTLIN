package com.nextu.pokedex.model.pokemon.sprite.generation

import kotlinx.serialization.Serializable

@Serializable
data class GenerationIISprites(
    val crystal: GenerationIIDefault,
    val gold: GenerationIIDefault,
    val silver: GenerationIIDefault
)

@Serializable
data class GenerationIIDefault(
    val front_default: String?,
    val front_shiny: String?,
    val back_default: String?,
    val back_shiny: String?,
    val back_shiny_transparent: String? = null,
    val back_transparent: String? = null,
    val front_shiny_transparent: String? = null,
    val front_transparent: String? = null
)