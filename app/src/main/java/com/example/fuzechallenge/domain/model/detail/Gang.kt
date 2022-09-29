package com.example.fuzechallenge.domain.model.detail

import com.example.fuzechallenge.presentation.model.detail.GangUiModel

class Gang(
    val id: Long,
    val imageUrl: String,
    val name: String,
    val slug: String,
    val players: List<Player>,
)

fun Gang.toUiModel() = GangUiModel(
    id = this.id,
    imageUrl = this.imageUrl,
    name = this.name,
    slug = this.slug,
    players = this.players.map { it.toUiModel() }
)