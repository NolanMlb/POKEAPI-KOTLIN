package com.nextu.pokedex.ui.theme.screen.home

import PokemonCard
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun HomePageScreen (viewModel: HomePageViewModel){
    val products = viewModel.products.collectAsState();

    Column (modifier = Modifier
        .fillMaxWidth()){
        LazyColumn {
            items(products.value.size){ index ->
                PokemonCard(pokemon = products.value[index])
            }
        }
    }
}