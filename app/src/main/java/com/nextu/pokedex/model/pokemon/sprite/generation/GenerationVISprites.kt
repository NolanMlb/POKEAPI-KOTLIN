package com.nextu.pokedex.model.pokemon.sprite.generation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVISprites(
    @SerialName("omegaruby-alphasapphire")
    val omegaruby_alphasapphire: GenerationVIDefault,
    @SerialName("x-y")
    val x_y: GenerationVIDefault
)

@Serializable
data class GenerationVIDefault(
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)