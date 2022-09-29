package com.example.fuzechallenge.data.model

import com.example.fuzechallenge.domain.model.NullTeam
import com.example.fuzechallenge.domain.model.Opponent
import com.google.gson.annotations.SerializedName

class OpponentResponse(
    @SerializedName("opponent") val opponent: TeamResponse?,
    @SerializedName("type") val type: String?
)

fun OpponentResponse.toDomainModel() = Opponent(
    opponent = opponent?.toDomainModel() ?: NullTeam(),
    type = this.type
)