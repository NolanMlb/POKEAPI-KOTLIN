package com.nextu.pokedex.model.pokemon.sprite.generation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVSprites(
    @SerialName("black-white")
    val black_white: GenerationVDefault
)

@Serializable
data class GenerationVDefault(
    val animated: GenerationVAnimated,
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,

    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

@Serializable
data class GenerationVAnimated(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,

    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)