package com.example.fuzechallenge.data.model

import com.google.gson.annotations.SerializedName

internal class MatchResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("scheduled_at")
    val scheduledAt: String?,
    @SerializedName("status")
    val status: String,
    @SerializedName("serie")
    val serie: SerieResponse?,
    @SerializedName("league")
    val league: LeagueResponse?,
    @SerializedName("opponents")
    val opponents: List<OpponentResponse>?
)
