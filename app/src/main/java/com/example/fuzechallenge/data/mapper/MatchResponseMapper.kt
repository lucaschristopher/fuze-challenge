package com.example.fuzechallenge.data.mapper

import com.example.fuzechallenge.data.model.MatchResponse
import com.example.fuzechallenge.domain.model.League
import com.example.fuzechallenge.domain.model.Match
import com.example.fuzechallenge.domain.model.Serie

internal fun MatchResponse.toDomain() = Match(
    id = this.id,
    scheduledAt = this.scheduledAt.orEmpty(),
    status = this.status,
    serie = this.serie?.toDomain() ?: Serie(),
    league = this.league?.toDomain() ?: League(),
    opponents = this.opponents?.map { it.toDomain() } ?: listOf()
)
