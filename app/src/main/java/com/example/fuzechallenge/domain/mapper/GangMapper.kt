package com.example.fuzechallenge.domain.mapper

import com.example.fuzechallenge.domain.model.Gang
import com.example.fuzechallenge.presentation.model.GangUIModel

fun Gang.toUI() = GangUIModel(
    id = this.id,
    imageUrl = this.imageUrl,
    name = this.name,
    slug = this.slug,
    players = this.players.map { it.toUI() }
)
