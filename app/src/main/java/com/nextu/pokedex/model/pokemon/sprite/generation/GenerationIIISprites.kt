package com.nextu.pokedex.model.pokemon.sprite.generation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIIISprites(
    val emerald: GenerationIIIDefault,
    @SerialName("firered-leafgreen")
    val firered_leafgreen: GenerationIIIDefault,
    @SerialName("ruby-sapphire")
    val ruby_sapphire: GenerationIIIDefault
)

@Serializable
data class GenerationIIIDefault (
    val front_default: String? = null,
    val front_shiny: String? = null,
    val back_default: String? = null,
    val back_shiny: String? = null
)