package com.example.fuzechallenge.presentation.model

class MatchUIModel(
    val id: Long = 0,
    val scheduledAt: String = "",
    val status: String = "",
    val serie: SerieUIModel = SerieUIModel(),
    val league: LeagueUIModel = LeagueUIModel(),
    val opponents: List<OpponentUIModel> = listOf()
)
