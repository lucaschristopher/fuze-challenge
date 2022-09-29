package com.example.fuzechallenge.presentation.model.detail

class GangUiModel(
    val id: Long,
    val imageUrl: String,
    val name: String,
    val slug: String,
    val players: List<PlayerUiModel>,
)