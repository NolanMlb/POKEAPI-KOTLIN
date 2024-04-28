package com.nextu.pokedex.model

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val language: BaseModel,
    val name: String
)