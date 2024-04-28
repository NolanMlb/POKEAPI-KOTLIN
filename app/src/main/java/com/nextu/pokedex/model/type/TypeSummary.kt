package com.nextu.pokedex.model.type

import com.nextu.pokedex.model.BaseModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TypeSummary(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String,
    var isSelected: Boolean = false
)