package com.example.fuzechallenge.domain.mapper

import com.example.fuzechallenge.domain.model.Serie
import com.example.fuzechallenge.presentation.model.SerieUIModel

fun Serie.toUI() = SerieUIModel(
    id = this.id,
    name = this.name,
    description = this.description,
    slug = this.slug
)
