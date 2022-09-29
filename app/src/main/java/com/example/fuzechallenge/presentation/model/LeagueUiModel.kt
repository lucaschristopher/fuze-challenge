package com.example.fuzechallenge.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class LeagueUiModel(
    val id: Long,
    val imageUrl: String?,
    val name: String?,
    val slug: String?,
    val url: String?
) : Parcelable