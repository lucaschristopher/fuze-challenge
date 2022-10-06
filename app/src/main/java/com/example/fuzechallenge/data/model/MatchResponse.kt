package com.example.fuzechallenge.data.model

import com.example.fuzechallenge.core.constants.EMPTY_STRING
import com.example.fuzechallenge.domain.model.Match
import com.example.fuzechallenge.domain.model.NullLeague
import com.example.fuzechallenge.domain.model.NullSerie
import com.google.gson.annotations.SerializedName

class MatchResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("scheduled_at") val scheduledAt: String?,
    @SerializedName("status") val status: String,
    @SerializedName("serie") val serie: SerieResponse?,
    @SerializedName("league") val league: LeagueResponse?,
    @SerializedName("opponents") val opponents: List<OpponentResponse>?
)

fun MatchResponse.toDomainModel() = Match(
    id = this.id,
    scheduledAt = this.scheduledAt ?: EMPTY_STRING,
    status = this.status,
    serie = this.serie?.toDomainModel() ?: NullSerie(),
    league = this.league?.toDomainModel() ?: NullLeague(),
    opponents = this.opponents?.map { it.toDomainModel() } ?: listOf(),
)
