package com.nextu.pokedex.model

import kotlinx.serialization.Serializable

@Serializable
class BaseModel(
    val name: String,
    val url: String
)