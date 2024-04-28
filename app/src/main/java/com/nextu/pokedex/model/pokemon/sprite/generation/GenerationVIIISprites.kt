package com.nextu.pokedex.model.pokemon.sprite.generation

import kotlinx.serialization.Serializable

@Serializable
data class GenerationVIIISprites(
    val icons: GenerationVIIIDefaultIcons
)

@Serializable
data class GenerationVIIIDefaultIcons(
    val front_default: String?,
    val front_female: String?
)