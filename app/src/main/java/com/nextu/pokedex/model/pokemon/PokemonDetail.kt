package com.nextu.pokedex.model.pokemon

import com.nextu.pokedex.model.BaseModel
import com.nextu.pokedex.model.GameIndex
import com.nextu.pokedex.model.pokemon.sprite.Sprites
import com.nextu.pokedex.model.type.TypeSummary
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDetail(
    val id: Int,
    val name: String,
    val base_experience: Int,
    val height: Int,
    val is_default: Boolean,
    val cries: Cries,
    val order: Int,
    val weight: Int,
    val abilities: List<Ability>,
    val forms: List<BaseModel>,
    val game_indices: List<GameIndex>,
    val held_items: List<HeldItem>,
    val location_area_encounters: String,
    val past_abilities: List<Ability>,
    val past_types: List<PastTypes>,
    val moves: List<Move>,
    val species: BaseModel,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<TypeData>
)

@Serializable
data class TypeData(
    val slot: Int,
    val type: TypeSummary
)

@Serializable
data class PastTypes(
    val slot: Int? = null,
    val type: TypeSummary? = null,
    val generation: BaseModel? = null,
    val types: List<TypeData>? = null
)