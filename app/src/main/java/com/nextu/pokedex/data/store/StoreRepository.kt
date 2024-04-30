package com.nextu.pokedex.data.store

import android.util.Log
import com.nextu.pokedex.model.pokemon.PokemonSummary
import com.nextu.pokedex.model.pokemon.PokemonDetail
import com.nextu.pokedex.model.type.TypeSummary
import com.nextu.pokedex.model.response.ApiResponse

class StoreRepository(private val endpoint: StoreEndpoint) {

    companion object {
        const val TAG = "StoreRepository"
    }

    suspend fun getAllPokemons(): List<PokemonSummary> {
        return try {
            val pokemonResponse = endpoint.getAllPokemons()
            pokemonResponse.results
        } catch (e: Exception) {
            println("error")
            Log.e(TAG, e.message.toString())
            listOf()
        }
    }

    suspend fun getTypes(): List<TypeSummary> {
        return try {
            val typesResponse = endpoint.getAllTypes()
            typesResponse.results
        } catch (e: Exception) {
            println("error")
            Log.e(TAG, e.message.toString())
            listOf()
        }

    }

    suspend fun getPokemonsByType(typeName: String): List<PokemonSummary> {
        return try {
            val response = endpoint.getPokemonsByType(typeName)
            response.pokemon.map { it.pokemon }
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            listOf()
        }
    }

    suspend fun getPokemonByName(pokemonName: String): PokemonDetail? {
        return try {
            endpoint.getPokemonByName(pokemonName)
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            null
        }
    }
}