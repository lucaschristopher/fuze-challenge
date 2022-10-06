package com.example.fuzechallenge.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class MatchUiModel(
    val id: Long,
    val scheduledAt: String,
    val status: String,
    val serie: SerieUiModel,
    val league: LeagueUiModel,
    val opponents: List<OpponentUiModel>
) : Parcelable
