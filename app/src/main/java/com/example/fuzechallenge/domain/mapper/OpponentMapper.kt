package com.example.fuzechallenge.domain.mapper

import com.example.fuzechallenge.domain.model.Opponent
import com.example.fuzechallenge.presentation.list.model.OpponentUIModel

internal fun Opponent.toUI() = OpponentUIModel(
    opponent = this.opponent.toUI(),
    type = this.type
)
