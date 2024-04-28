package com.nextu.pokedex

import android.app.Application
import com.nextu.pokedex.data.AppContainer
import com.nextu.pokedex.data.DefaultAppContainer

class NextUApplication : Application() {

    lateinit var container : AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}