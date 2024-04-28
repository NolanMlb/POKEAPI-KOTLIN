package com.nextu.pokedex.model.pokemon.sprite

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OtherSprites(
    val dream_world: DreamWorld?,
    val home: Home?,
    @SerialName("official-artwork")
    val official_artwork: OfficialArtwork?,
    val showdown: Showdown?
)

@Serializable
data class DreamWorld (
    val front_default: String?,
    val front_female: String?
)

@Serializable
data class OfficialArtwork(
    val front_default: String?,
    val front_shiny: String?
)

@Serializable
data class Showdown(
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?,

    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?
)

@Serializable
data class Home(
    val front_default: String?,
    val front_shiny: String?,
    val front_female: String?,
    val front_shiny_female: String?,
)