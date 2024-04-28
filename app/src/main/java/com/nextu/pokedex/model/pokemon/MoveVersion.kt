package com.nextu.pokedex.model.pokemon

import com.nextu.pokedex.model.BaseModel
import kotlinx.serialization.Serializable

@Serializable
data class MoveVersion(
    val level_learned_at: Int,
    val move_learn_method: BaseModel,
    val version_group: BaseModel
)