package com.nextu.pokedex.model

import kotlinx.serialization.Serializable

@Serializable
data class PastDamageRelation(
    val damage_relations: DamageRelations,
    val generation: BaseModel,
)