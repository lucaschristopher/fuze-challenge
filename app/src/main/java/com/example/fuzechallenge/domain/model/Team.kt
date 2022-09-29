package com.example.fuzechallenge.domain.model

import com.example.fuzechallenge.core.constants.DEFAULT_ID
import com.example.fuzechallenge.core.constants.EMPTY_STRING
import com.example.fuzechallenge.presentation.model.TeamUiModel

open class Team(
    val id: Long,
    val imageUrl: String?,
    val location: String?,
    val name: String?,
    val slug: String?
)

fun Team.toUiModel() = TeamUiModel(
    id = this.id,
    imageUrl = this.imageUrl,
    location = this.location,
    name = this.name,
    slug = this.slug
)

// Null object pattern
class NullTeam : Team(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    location = EMPTY_STRING,
    name = EMPTY_STRING,
    slug = EMPTY_STRING
)