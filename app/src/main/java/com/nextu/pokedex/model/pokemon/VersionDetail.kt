package com.nextu.pokedex.model.pokemon

import com.nextu.pokedex.model.BaseModel
import kotlinx.serialization.Serializable

@Serializable
data class VersionDetail(
    val rarity: Int,
    val version: BaseModel
)