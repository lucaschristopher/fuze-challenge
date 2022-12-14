package com.example.fuzechallenge.domain.model

import com.example.fuzechallenge.presentation.model.MatchUiModel

class Match(
    val id: Long,
    val scheduledAt: String,
    val status: String,
    val serie: Serie,
    val league: League,
    val opponents: List<Opponent>
)

fun Match.toUiModel() = MatchUiModel(
    id = this.id,
    scheduledAt = this.scheduledAt,
    status = this.status,
    serie = this.serie.toUiModel(),
    league = this.league.toUiModel(),
    opponents = opponents.map { it.toUiModel() }
)