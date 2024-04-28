package com.nextu.pokedex.ui.theme.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.nextu.pokedex.data.store.StoreEndpoint
import com.nextu.pokedex.model.pokemon.PokemonSummary
import com.nextu.pokedex.model.response.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class HomePageViewModel: ViewModel() {
    private var storeEndpoint : StoreEndpoint? = null
    var products = MutableStateFlow<List<PokemonSummary>>(emptyList())

    init {
        val okHttpClient = OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        val retrofit = Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient.build())
            .baseUrl("https://fakestoreapi.com/")
            .build()
        storeEndpoint = retrofit.create(StoreEndpoint::class.java)
        viewModelScope.launch(Dispatchers.IO) {
            fetchAllProducts()
        }
    }

    private suspend fun fetchAllProducts() {
        val response = storeEndpoint?.getAllPokemons()
        if (response != null) {
            products.value = response.results
        }
        Log.d("HomePageViewModel", "received ${products.value?.size ?: "0"} products")
    }
}