package com.example.fuzechallenge.domain.model

import com.example.fuzechallenge.core.constants.DEFAULT_ID
import com.example.fuzechallenge.core.constants.EMPTY_STRING
import com.example.fuzechallenge.presentation.model.SerieUiModel

open class Serie(
    val id: Long,
    val name: String?,
    val description: String?,
    val slug: String?,
)

fun Serie.toUiModel() = SerieUiModel(
    id = this.id,
    name = this.name,
    description = this.description,
    slug = this.slug
)

// Null object pattern
class NullSerie : Serie(
    id = DEFAULT_ID,
    name = EMPTY_STRING,
    description = EMPTY_STRING,
    slug = EMPTY_STRING
)
