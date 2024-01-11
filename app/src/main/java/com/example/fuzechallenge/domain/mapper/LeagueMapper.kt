package com.example.fuzechallenge.domain.mapper

import com.example.fuzechallenge.domain.model.League
import com.example.fuzechallenge.presentation.model.LeagueUIModel

fun League.toUI() = LeagueUIModel(
    id = this.id,
    imageUrl = this.imageUrl,
    name = this.name,
    slug = this.slug,
    url = this.url
)
