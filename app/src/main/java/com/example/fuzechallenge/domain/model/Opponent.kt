package com.example.fuzechallenge.domain.model

import com.example.fuzechallenge.presentation.model.OpponentUiModel

class Opponent(
    val opponent: Team,
    val type: String?
)

fun Opponent.toUiModel() = OpponentUiModel(
    opponent = this.opponent.toUiModel(),
    type = this.type
)