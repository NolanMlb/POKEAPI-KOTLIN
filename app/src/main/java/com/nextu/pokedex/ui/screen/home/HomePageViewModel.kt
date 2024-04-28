package com.nextu.pokedex.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nextu.pokedex.model.pokemon.PokemonSummary
import com.nextu.pokedex.data.store.StoreRepository
import com.nextu.pokedex.model.type.TypeSummary
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomePageViewModel(private val storeRepository: StoreRepository) : ViewModel() {

    companion object {
        const val TYPE_ALL = "All"
    }

    private val _state = MutableStateFlow<HomePageState>(HomePageState())
    val state: StateFlow<HomePageState> = _state.asStateFlow()

    data class HomePageState(
        val pokemons: List<PokemonSummary> = listOf(),
        val types: List<TypeSummary> = listOf(),
        val isLoading: Boolean = false,
    )

    fun loadPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { state ->
                state.copy(
                    isLoading = true
                )
            }
            fetchTypes()
            fetchAllPokemons()
            _state.update { state ->
                state.copy(
                    isLoading = false
                )
            }
        }
    }

    fun loadPokemonsByType(type: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { state ->
                state.copy(
                    isLoading = true,
                    types = state.types.map {
                        item -> item.isSelected = item.name == type
                        item
                    }
                )
            }
            fetchPokemonsByType(type)
            _state.update { state ->
                state.copy(
                    isLoading = false
                )
            }
        }
    }


    private suspend fun fetchAllPokemons() {
        val pokemonRequest = storeRepository.getAllPokemons()
        _state.update { state ->
            state.copy(
                pokemons = pokemonRequest,
            )
        }
    }

    private suspend fun fetchPokemonsByType(typeName: String) {
        var result = emptyList<PokemonSummary>()
        if (typeName == TYPE_ALL) result = storeRepository.getAllPokemons()
        else result = storeRepository.getPokemonsByType(typeName)
        _state.update { state ->
            state.copy(
                pokemons = result
            )
        }
    }

    private suspend fun fetchTypes() {
        val typesList = storeRepository.getTypes()
        println("Types: $typesList")
        _state.update { state ->
            state.copy(
                types = typesList
                    .toMutableList()                                        // On rend la liste mutable
                    .apply {                         // Ici on ajoute l'élément ALL qui n'est pas retourné par le webservice et qui sera notre premier type
                        add(0, TypeSummary(TYPE_ALL,"", true))
                    }.toList(),
            )
        }
    }

}
