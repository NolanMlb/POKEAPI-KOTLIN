package com.nextu.pokedex.ui.screen.detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.nextu.pokedex.ui.component.LoadingContent
import com.nextu.pokedex.ui.extension.OnStartEffect

@Composable
fun PokemonDetailScreen (pokemonDetailViewModel: PokemonDetailViewModel, pokemonName: String, navToBackScreen: () -> Unit) {
    val state by pokemonDetailViewModel.state.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current
    val pngUrls = mutableListOf<String>()
    state.pokemon?.sprites?.let { sprites ->
        val properties = listOf(sprites.front_default, sprites.back_default, sprites.front_shiny, sprites.back_shiny)
        properties.forEach { url ->
            if (url != null && url.endsWith(".png")) {
                pngUrls.add(url)
            }
        }
    }

    OnStartEffect(lifecycleOwner){
        pokemonDetailViewModel.loadPokemon(pokemonName = pokemonName)
    }

    Column(
        modifier=Modifier.fillMaxSize(),
    ){
        if (state.isLoading) {
            LoadingContent()
        } else {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ){
                IconButton(
                    onClick = { navToBackScreen() },
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                        contentDescription = "Back arrow",
                    )
                }
                Text(
                    text = "${state.pokemon?.order} / 1302",
                    fontSize = 20.sp
                )
            }
            Column (
                Modifier
                    .padding(20.dp)
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    LazyRow {
                        items(pngUrls.size) { index ->
                            val picture = pngUrls[index] ?: ""
                            AsyncImage(
                                model = picture,
                                contentDescription = "Image of the product ${state.pokemon?.name}",
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier
                                    .width(400.dp)
                                    .height(400.dp)
                                    .padding(10.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                        }
                    }
                    Text(
                        text=state.pokemon?.name ?: "",
                        fontWeight = FontWeight.Bold,
                        fontSize = 45.sp,
                        lineHeight = 35.sp
                    )
                }

                Column (
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(16.dp)
                        .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.medium)
                        .fillMaxWidth()
                        .height(200.dp)
                ){
                    Text(text = "Abilities :",
                        fontSize = 30.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                    state.pokemon?.abilities?.forEach { type ->
                        Text(
                            text = "- ${type.ability.name}",
                            fontSize = 25.sp,
                            modifier = Modifier.padding(6.dp)
                        )
                    }

                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Height: ${state.pokemon?.height} dm", fontSize = 20.sp)
                Text(text = "Weight: ${state.pokemon?.weight} hg", fontSize = 20.sp)
            }
        }
    }
}