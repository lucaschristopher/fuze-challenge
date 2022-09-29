package com.example.fuzechallenge.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class SerieUiModel(
    val id: Long,
    val name: String?,
    val description: String?,
    val slug: String?,
) : Parcelable