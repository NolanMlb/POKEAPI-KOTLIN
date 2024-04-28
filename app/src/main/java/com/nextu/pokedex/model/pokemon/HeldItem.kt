package com.nextu.pokedex.model.pokemon

import com.nextu.pokedex.model.BaseModel
import kotlinx.serialization.Serializable

@Serializable
data class HeldItem (
    val item: BaseModel,
    val version_details: List<VersionDetail>
)