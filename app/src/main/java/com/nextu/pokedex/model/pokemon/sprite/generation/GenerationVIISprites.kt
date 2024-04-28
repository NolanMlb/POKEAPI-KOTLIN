package com.nextu.pokedex.model.pokemon.sprite.generation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVIISprites(
    val icons: GenerationVIIDefaultIcons?,
    @SerialName("ultra-sun-ultra-moon")
    val ultra_sun_ultra_moon: GenerationVIIDefault?
)

@Serializable
data class GenerationVIIDefaultIcons(
    val front_default: String?,
    val front_female: String?,
)

@Serializable
data class GenerationVIIDefault(
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?,
)