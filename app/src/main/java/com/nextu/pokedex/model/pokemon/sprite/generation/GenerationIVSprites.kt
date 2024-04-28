package com.nextu.pokedex.model.pokemon.sprite.generation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIVSprites(
    @SerialName("diamond-pearl")
    val diamond_pearl: GenerationIVDefault,
    @SerialName("heartgold-soulsilver")
    val heartgold_soulsilver: GenerationIVDefault,
    val platinum: GenerationIVDefault
)

@Serializable
data class GenerationIVDefault(
    val front_default: String?,
    val front_shiny: String?,
    val front_female: String?,
    val front_shiny_female: String?,
    val back_default: String?,
    val back_shiny: String?,
    val back_female: String?,
    val back_shiny_female: String?
)