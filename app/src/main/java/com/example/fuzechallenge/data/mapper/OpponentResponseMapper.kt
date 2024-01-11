package com.example.fuzechallenge.data.mapper

import com.example.fuzechallenge.data.model.OpponentResponse
import com.example.fuzechallenge.domain.model.Opponent
import com.example.fuzechallenge.domain.model.Team

fun OpponentResponse.toDomain() = Opponent(
    opponent = this.opponent?.toDomain() ?: Team(),
    type = this.type
)
