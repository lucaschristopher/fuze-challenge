package com.example.fuzechallenge.domain.model.detail

import com.example.fuzechallenge.presentation.model.detail.PlayerUiModel

class Player(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val imageUrl: String,
    val slug: String,
)

fun Player.toUiModel() = PlayerUiModel(
    id = this.id,
    firstName = this.firstName,
    lastName = this.lastName,
    imageUrl = this.imageUrl,
    slug = this.slug
)