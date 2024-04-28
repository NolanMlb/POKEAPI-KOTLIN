package com.nextu.pokedex.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nextu.pokedex.data.store.StoreRepository
import com.nextu.pokedex.model.pokemon.PokemonDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonDetailViewModel (private val storeRepository: StoreRepository): ViewModel() {

    private val _state = MutableStateFlow<PokemonDetailViewModel.ProductDetailState>(PokemonDetailViewModel.ProductDetailState())
    val state: StateFlow<PokemonDetailViewModel.ProductDetailState> = _state.asStateFlow()

    data class ProductDetailState(
        val pokemon: PokemonDetail? = null,
        val isLoading: Boolean = false
    )

    fun loadPokemon(pokemonName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { state ->
                state.copy(
                    isLoading = true
                )
            }
            fetchPokemonDetail(pokemonName = pokemonName)
            _state.update { state ->
                state.copy(
                    isLoading = false
                )
            }
        }

    }

    suspend fun fetchPokemonDetail(pokemonName: String) {
        val result = storeRepository.getPokemonByName(pokemonName = pokemonName)
        _state.update {
            it.copy(
                pokemon = result
            )
        }
    }
}