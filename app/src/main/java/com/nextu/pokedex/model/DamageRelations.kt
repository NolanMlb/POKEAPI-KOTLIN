package com.nextu.pokedex.model

import kotlinx.serialization.Serializable

@Serializable
data class DamageRelations(
    val double_damage_from: List<BaseModel>,
    val double_damage_to: List<BaseModel>,
    val half_damage_from: List<BaseModel>,
    val half_damage_to: List<BaseModel>,
    val no_damage_from: List<BaseModel>,
    val no_damage_to: List<BaseModel>
)