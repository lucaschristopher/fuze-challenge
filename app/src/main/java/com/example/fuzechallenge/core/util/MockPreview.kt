package com.example.fuzechallenge.core.util

import com.example.fuzechallenge.core.constants.EMPTY_STRING
import com.example.fuzechallenge.presentation.model.LeagueUiModel
import com.example.fuzechallenge.presentation.model.OpponentUiModel
import com.example.fuzechallenge.presentation.model.SerieUiModel
import com.example.fuzechallenge.presentation.model.TeamUiModel
import com.example.fuzechallenge.presentation.model.detail.PlayerUiModel

val mockPlayerPreview = PlayerUiModel(
    id = 37847,
    firstName = "Paulo",
    lastName = "Costa",
    imageUrl = "https://cdn.pandascore.co/images/player/image/37847/dscf5074_scaled.png",
    slug = "agr"
)

val mockBeginAtPreview = EMPTY_STRING
val mockStatusPreview = EMPTY_STRING
val mockSeriePreview = SerieUiModel(
    id = 0,
    name = "Moscow",
    description = EMPTY_STRING,
    slug = "cs-go-epicenter-moscow-2016"
)
val mockLeaguePreview = LeagueUiModel(
    id = 4156,
    name = "EPICENTER",
    imageUrl = "https://cdn.pandascore.co/images/league/image/4156/600px-EPICENTER.svg.png",
    url = EMPTY_STRING,
    slug = "cs-go-epicenter"
)
val mockOpponentsPreview = listOf(
    OpponentUiModel(
        type = "Time",
        opponent = TeamUiModel(
            id = 3288,
            imageUrl = "https://cdn.pandascore.co/images/team/image/3288/600px_virtus.pro_2019.png",
            name = "Virtus.pro",
            slug = "virtus-pro-75b4744b-43d9-4ebd-a8dc-f1e0f9be69b3",
            location = "RU"
        )
    ),
    OpponentUiModel(
        type = "Time",
        opponent = TeamUiModel(
            id = 3207,
            imageUrl = "https://cdn.pandascore.co/images/team/image/3207/SK_GAMMING.png",
            name = "SK",
            slug = "sk",
            location = "DE"
        )
    )
)