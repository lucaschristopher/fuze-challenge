package com.example.fuzechallenge.domain.model

import com.example.fuzechallenge.core.constants.DEFAULT_ID
import com.example.fuzechallenge.core.constants.EMPTY_STRING
import com.example.fuzechallenge.presentation.model.LeagueUiModel

open class League(
    val id: Long,
    val imageUrl: String?,
    val name: String?,
    val slug: String?,
    val url: String?
)

fun League.toUiModel() = LeagueUiModel(
    id = this.id,
    imageUrl = this.imageUrl,
    name = this.name,
    slug = this.slug,
    url = this.url
)

// Null object pattern
class NullLeague : League(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    url = EMPTY_STRING
)