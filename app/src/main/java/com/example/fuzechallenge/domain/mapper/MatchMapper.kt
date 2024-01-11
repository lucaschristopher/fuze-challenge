package com.example.fuzechallenge.domain.mapper

import com.example.fuzechallenge.domain.model.Match
import com.example.fuzechallenge.presentation.model.MatchUIModel

fun Match.toUI() = MatchUIModel(
    id = this.id,
    scheduledAt = this.scheduledAt,
    status = this.status,
    serie = this.serie.toUI(),
    league = this.league.toUI(),
    opponents = this.opponents.map { it.toUI() }
)
