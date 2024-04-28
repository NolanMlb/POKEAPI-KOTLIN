package com.nextu.pokedex.ui.screen.home.component

import PokemonCard
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nextu.pokedex.model.pokemon.PokemonSummary
import com.nextu.pokedex.model.type.TypeSummary
import com.nextu.pokedex.ui.theme.NextU_android_advancedTheme
import com.nextu.pokedex.ui.theme.Typography

@Composable
fun PokemonListContent(
    types: List<TypeSummary>,
    pokemons: List<PokemonSummary>,
    onClickType: (typeName: String) -> Unit,
    onClickProduct: (productId: String) -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            "${types.firstOrNull { it.isSelected }?.name ?: ""}",
            style = Typography.titleLarge.copy(fontSize = 32.sp)
        )
        Text("Collection", style = Typography.bodyLarge)
    }

    // LazyRow avec les catégories
    LazyRow(
        Modifier
            .fillMaxWidth()
            .scrollable(rememberScrollState(), orientation = Orientation.Vertical),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
    ) {
        items(types.size) { index ->
            val type = types[index]
            FilterChip(
                selected = type.isSelected,
                onClick = { onClickType(type.name) },
                label = { Text(type.name) },
                modifier = Modifier.padding(horizontal = 4.dp),
            )
        }
    }

    // La grille avec les produits
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        items(pokemons.size) { index ->
            val product = pokemons[index]
            PokemonCard(
                pokemon = product,
                modifier = Modifier.clickable { onClickProduct(product.name.toString()) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductListContentPreview() {
    NextU_android_advancedTheme {
        Column {
            PokemonListContent(
                listOf(TypeSummary("All", "")), listOf(
                    PokemonSummary(
                        name="Pikachu",
                        url= "https"
                    ), PokemonSummary(
                        name="Evoli",
                        url= "https"
                    )
                ), {}, {}
            )
        }
    }
}