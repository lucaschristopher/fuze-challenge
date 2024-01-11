package com.example.fuzechallenge.presentation.ui.utils.preview

import com.example.fuzechallenge.presentation.model.LeagueUIModel
import com.example.fuzechallenge.presentation.model.MatchUIModel
import com.example.fuzechallenge.presentation.model.OpponentUIModel
import com.example.fuzechallenge.presentation.model.PlayerUIModel
import com.example.fuzechallenge.presentation.model.SerieUIModel
import com.example.fuzechallenge.presentation.model.TeamUIModel

class MockPreview {

    companion object {

        val mockPlayerUIModel = PlayerUIModel(
            id = 37847,
            firstName = "Paulo",
            lastName = "Costa",
            imageUrl = "https://cdn.pandascore.co/images/player/image/37847/dscf5074_scaled.png",
            slug = "agr"
        )


        val mockSerieUIModel = SerieUIModel(
            id = 0,
            name = "Moscow",
            description = "",
            slug = "cs-go-epicenter-moscow-2016"
        )

        val mockLeagueUIModel = LeagueUIModel(
            id = 4156,
            name = "EPICENTER",
            imageUrl = "https://cdn.pandascore.co/images/league/image/4156/600px-EPICENTER.svg.png",
            url = "",
            slug = "cs-go-epicenter"
        )

        val mockOpponentList = listOf(
            OpponentUIModel(
                type = "Time",
                opponent = TeamUIModel(
                    id = 3288,
                    imageUrl = "https://cdn.pandascore.co/images/team/image/3288/600px_virtus.pro_2019.png",
                    name = "Virtus.pro",
                    slug = "virtus-pro-75b4744b-43d9-4ebd-a8dc-f1e0f9be69b3",
                    location = "RU"
                )
            ),
            OpponentUIModel(
                type = "Time",
                opponent = TeamUIModel(
                    id = 3207,
                    imageUrl = "https://cdn.pandascore.co/images/team/image/3207/SK_GAMMING.png",
                    name = "SK",
                    slug = "sk",
                    location = "DE"
                )
            )
        )

        val mockMatchUIModel = MatchUIModel(
            id = 0,
            scheduledAt = "",
            status = "",
            serie = mockSerieUIModel,
            league = mockLeagueUIModel,
            opponents = mockOpponentList
        )
    }
}
