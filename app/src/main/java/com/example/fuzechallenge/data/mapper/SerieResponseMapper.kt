package com.example.fuzechallenge.data.mapper

import com.example.fuzechallenge.data.model.SerieResponse
import com.example.fuzechallenge.domain.model.Serie

internal fun SerieResponse.toDomain() = Serie(
    id = this.id,
    name = this.name.orEmpty(),
    description = this.description.orEmpty(),
    slug = this.slug.orEmpty()
)
