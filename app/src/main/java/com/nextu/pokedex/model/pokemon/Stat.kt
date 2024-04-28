package com.nextu.pokedex.model.pokemon

import com.nextu.pokedex.model.BaseModel
import kotlinx.serialization.Serializable

@Serializable
data class Stat(
    val base_stat: Int,
    val effort: Int,
    val stat: BaseModel
)