package com.nextu.pokedex.data.store

import com.nextu.pokedex.model.pokemon.PokemonSummary
import com.nextu.pokedex.model.pokemon.PokemonDetail
import com.nextu.pokedex.model.type.TypeSummary
import com.nextu.pokedex.model.response.ApiResponse
import com.nextu.pokedex.model.type.TypeDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreEndpoint {

    @GET("pokemon?offset=0&limit=1302")
    suspend fun getAllPokemons(): ApiResponse<PokemonSummary>

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonByName(@Path("pokemonName") pokemonName: String): PokemonDetail?

    @GET("type/{typeName}")
    suspend fun getPokemonsByType(@Path("typeName") typeName: String): TypeDetail

    @GET("type/")
    suspend fun getAllTypes(): ApiResponse<TypeSummary>


}