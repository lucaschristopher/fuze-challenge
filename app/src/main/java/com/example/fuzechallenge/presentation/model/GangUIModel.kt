package com.example.fuzechallenge.presentation.model

class GangUIModel(
    val id: Long = 0,
    val imageUrl: String = "",
    val name: String = "",
    val slug: String = "",
    val players: List<PlayerUIModel> = listOf(),
)
