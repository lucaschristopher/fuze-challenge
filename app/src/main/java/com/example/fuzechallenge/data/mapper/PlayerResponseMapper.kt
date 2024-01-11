package com.example.fuzechallenge.data.mapper

import com.example.fuzechallenge.data.model.PlayerResponse
import com.example.fuzechallenge.domain.model.Player

fun PlayerResponse.toDomain() = Player(
    id = this.id,
    firstName = this.firstName.orEmpty(),
    lastName = this.lastName.orEmpty(),
    imageUrl = this.imageUrl.orEmpty(),
    slug = this.slug.orEmpty()
)
