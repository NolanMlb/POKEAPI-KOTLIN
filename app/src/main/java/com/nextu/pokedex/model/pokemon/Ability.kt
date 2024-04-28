package com.nextu.pokedex.model.pokemon

import com.nextu.pokedex.model.BaseModel
import kotlinx.serialization.Serializable

@Serializable
data class Ability (
    val ability: BaseModel,
    val is_hidden: Boolean,
    val slot: Int
)