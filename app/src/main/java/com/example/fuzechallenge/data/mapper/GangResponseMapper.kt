package com.example.fuzechallenge.data.mapper

import com.example.fuzechallenge.data.model.GangResponse
import com.example.fuzechallenge.domain.model.Gang

fun GangResponse.toDomain() = Gang(
    id = this.id,
    imageUrl = this.imageUrl.orEmpty(),
    name = this.name.orEmpty(),
    slug = this.slug.orEmpty(),
    players = this.players?.map { it.toDomain() } ?: listOf()
)
