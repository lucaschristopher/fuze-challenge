package com.example.fuzechallenge.data.mapper

import com.example.fuzechallenge.data.model.TeamResponse
import com.example.fuzechallenge.domain.model.Team

fun TeamResponse.toDomain() = Team(
    id = this.id,
    imageUrl = this.imageUrl.orEmpty(),
    location = this.location.orEmpty(),
    name = this.name.orEmpty(),
    slug = this.slug.orEmpty()
)
