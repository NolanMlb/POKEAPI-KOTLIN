package com.nextu.pokedex.model

import kotlinx.serialization.Serializable

@Serializable
data class GameIndex(
    val game_index: Int,
    val generation: BaseModel? = null,
    val version: BaseModel? = null
)