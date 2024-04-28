package com.nextu.pokedex.model.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSummary(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)













