package com.nextu.pokedex.model.pokemon

import com.nextu.pokedex.model.BaseModel
import kotlinx.serialization.Serializable

@Serializable
data class Move(
    val move: BaseModel,
    val version_group_details: List<MoveVersion>? = null
)