package com.example.fuzechallenge.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class TeamUiModel(
    val id: Long,
    val imageUrl: String?,
    val location: String?,
    val name: String?,
    val slug: String?
) : Parcelable