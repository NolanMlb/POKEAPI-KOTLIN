package com.nextu.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nextu.pokedex.ui.screen.detail.PokemonDetailScreen
import com.nextu.pokedex.ui.screen.detail.PokemonDetailViewModel
import com.nextu.pokedex.ui.screen.home.HomePageScreen
import com.nextu.pokedex.ui.screen.home.HomePageViewModel
import com.nextu.pokedex.ui.theme.NextU_android_advancedTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NextU_android_advancedTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    var context = LocalContext.current
    val homePageViewModel = remember {
        HomePageViewModel((context.applicationContext as NextUApplication).container.storeRepository)
    }
    val pokemonDetailViewModel = remember {
        PokemonDetailViewModel((context.applicationContext as NextUApplication).container.storeRepository)
    }
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_PAGE.label) {
        composable(Routes.HOME_PAGE.label) {
            HomePageScreen(
                homePageViewModel = homePageViewModel,
                navToDetail = {
                    productId ->
                    val productRoute = Routes.POKEMON_DETAIL.label.replace("{pokemonName}", productId)
                    navController.navigate(productRoute)
                }
            )
        }

        composable(Routes.POKEMON_DETAIL.label, arguments = listOf(navArgument("pokemonName") { type = NavType.StringType })
        ) { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString(
                "pokemonName",
                "-1"
            ) ?: "-1"
            PokemonDetailScreen(
                pokemonDetailViewModel = pokemonDetailViewModel,
                pokemonName = pokemonName,
                navToBackScreen = {
                    navController.popBackStack()
                }
            )
        }
    }
}

enum class Routes(val label: String) {
    HOME_PAGE( label = "home_page"),
    POKEMON_DETAIL(label = "pokemons/{pokemonName}/detail")
}
