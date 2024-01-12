package com.example.fuzechallenge.domain.mapper

import com.example.fuzechallenge.domain.model.Serie
import com.example.fuzechallenge.presentation.list.model.SerieUIModel

internal fun Serie.toUI() = SerieUIModel(
    id = this.id,
    name = this.name,
    description = this.description,
    slug = this.slug
)
