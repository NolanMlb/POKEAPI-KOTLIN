package com.nextu.pokedex.model.type

import com.nextu.pokedex.model.BaseModel
import com.nextu.pokedex.model.DamageRelations
import com.nextu.pokedex.model.GameIndex
import com.nextu.pokedex.model.Name
import com.nextu.pokedex.model.PastDamageRelation
import com.nextu.pokedex.model.pokemon.PokemonSummary
import kotlinx.serialization.Serializable

@Serializable
data class TypePokemon(
    val slot: Int,
    val pokemon: PokemonSummary
)

@Serializable
data class TypeDetail(
    val id: Int,
    val damage_relations: DamageRelations,
    val game_indices: List<GameIndex>,
    val generation: BaseModel,
    val move_damage_class: BaseModel? = null,
    val moves: List<BaseModel>,
    val name: String,
    val names: List<Name>,
    val past_damage_relations: List<PastDamageRelation>,
    val pokemon: List<TypePokemon>
)