package com.nextu.pokedex.model.pokemon.sprite

import kotlinx.serialization.Serializable

@Serializable
data class Sprites(
    val front_default: String?,
    val front_shiny: String?,
    val front_female: String?,
    val front_shiny_female: String?,

    val back_default: String?,
    val back_shiny: String?,
    val back_female: String?,
    val back_shiny_female: String?,
    val other: OtherSprites?,
    val versions: VersionSprites?
)