package com.nextu.pokedex.model.pokemon.sprite

import com.nextu.pokedex.model.pokemon.sprite.generation.GenerationIIISprites
import com.nextu.pokedex.model.pokemon.sprite.generation.GenerationIISprites
import com.nextu.pokedex.model.pokemon.sprite.generation.GenerationISprites
import com.nextu.pokedex.model.pokemon.sprite.generation.GenerationIVSprites
import com.nextu.pokedex.model.pokemon.sprite.generation.GenerationVIIISprites
import com.nextu.pokedex.model.pokemon.sprite.generation.GenerationVIISprites
import com.nextu.pokedex.model.pokemon.sprite.generation.GenerationVISprites
import com.nextu.pokedex.model.pokemon.sprite.generation.GenerationVSprites
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionSprites(
    @SerialName("generation-i")
    val generation_i: GenerationISprites?,
    @SerialName("generation-ii")
    val generation_ii: GenerationIISprites?,
    @SerialName("generation-iii")
    val generation_iii: GenerationIIISprites?,
    @SerialName("generation-iv")
    val generation_iv: GenerationIVSprites?,
    @SerialName("generation-v")
    val generation_v: GenerationVSprites?,
    @SerialName("generation-vi")
    val generation_vi: GenerationVISprites?,
    @SerialName("generation-vii")
    val generation_vii: GenerationVIISprites?,
    @SerialName("generation-viii")
    val generation_viii: GenerationVIIISprites?
)