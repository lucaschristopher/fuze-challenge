package com.example.fuzechallenge.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class OpponentUiModel(
    val opponent: TeamUiModel,
    val type: String?
) : Parcelable