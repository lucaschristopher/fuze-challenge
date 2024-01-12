package com.example.fuzechallenge.data.mapper

import com.example.fuzechallenge.data.model.LeagueResponse
import com.example.fuzechallenge.domain.model.League

internal fun LeagueResponse.toDomain() = League(
    id = this.id,
    imageUrl = this.imageUrl.orEmpty(),
    name = this.name.orEmpty(),
    slug = this.slug.orEmpty(),
    url = this.url.orEmpty()
)
