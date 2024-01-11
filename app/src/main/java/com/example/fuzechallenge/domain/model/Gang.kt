package com.example.fuzechallenge.domain.model

class Gang(
    val id: Long = 0,
    val imageUrl: String = "",
    val name: String = "",
    val slug: String = "",
    val players: List<Player> = listOf(),
)
