package com.example.fuzechallenge.domain.mapper

import com.example.fuzechallenge.domain.model.Team
import com.example.fuzechallenge.presentation.list.model.TeamUIModel

internal fun Team.toUI() = TeamUIModel(
    id = this.id,
    imageUrl = this.imageUrl,
    location = this.location,
    name = this.name,
    slug = this.slug
)
