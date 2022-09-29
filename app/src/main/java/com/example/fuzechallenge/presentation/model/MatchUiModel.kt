package com.example.fuzechallenge.presentation.model

class MatchUiModel(
    val scheduledAt: String,
    val status: String,
    val serie: SerieUiModel,
    val league: LeagueUiModel,
    val opponents: List<OpponentUiModel>
)