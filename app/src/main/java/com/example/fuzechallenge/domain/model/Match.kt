package com.example.fuzechallenge.domain.model

class Match(
    val id: Long = 0,
    val scheduledAt: String = "",
    val status: String = "",
    val serie: Serie = Serie(),
    val league: League = League(),
    val opponents: List<Opponent> = listOf()
)
