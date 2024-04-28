package com.nextu.pokedex.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nextu.pokedex.ui.component.LoadingContent
import com.nextu.pokedex.ui.extension.OnStartEffect
import com.nextu.pokedex.ui.screen.home.component.PokemonListContent

@Composable
fun HomePageScreen(homePageViewModel: HomePageViewModel, navToDetail: (productId: String) -> Unit) {
    val state by homePageViewModel.state.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current

    // On va charger la liste de produits et catégories depuis le OnStart() du lifecycle
    OnStartEffect(lifecycleOwner) {
        homePageViewModel.loadPokemons()
    }

    Column(
        Modifier
            .fillMaxSize()
    ) {
        if (state.isLoading) {
            LoadingContent()
        } else {
            PokemonListContent(
                types = state.types,
                pokemons = state.pokemons,
                onClickType = { typeName ->
                    homePageViewModel.loadPokemonsByType(typeName)
                },
                onClickProduct = { productId -> navToDetail(productId.toString()) }
            )
        }
    }
}

