package com.example.fuzechallenge.domain.mapper

import com.example.fuzechallenge.domain.model.Player
import com.example.fuzechallenge.presentation.model.PlayerUIModel

fun Player.toUI() = PlayerUIModel(
    id = this.id,
    firstName = this.firstName,
    lastName = this.lastName,
    imageUrl = this.imageUrl,
    slug = this.slug
)
