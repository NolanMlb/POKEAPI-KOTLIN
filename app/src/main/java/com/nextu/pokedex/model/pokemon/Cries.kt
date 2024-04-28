package com.nextu.pokedex.model.pokemon

import kotlinx.serialization.Serializable

@Serializable
data class Cries(
    val latest: String,
    val legacy: String
)