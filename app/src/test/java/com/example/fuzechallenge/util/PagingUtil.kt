package com.example.fuzechallenge.util

import com.example.fuzechallenge.data.model.detail.GangResponse
import com.example.fuzechallenge.data.model.detail.PlayerResponse
import com.example.fuzechallenge.domain.model.*

object PagingUtil {

    fun generateGangResponse() = GangResponse(
        id = 1000L,
        imageUrl = "imageUrl",
        name = "name",
        slug = "slug",
        players = generateListPlayers()
    )

    private fun generateListPlayers() = listOf(
        PlayerResponse(
            id = 1000L,
            imageUrl = "imageUrl",
            slug = "slug",
            firstName = "firstName",
            lastName = "lastName"
        )
    )

    fun generateMatch() = Match(
        scheduledAt = "scheduledAt",
        status = "status",
        serie = generateSerie(),
        league = generateLeague(),
        opponents = generateListOpponent()
    )

    private fun generateSerie() = Serie(
        id = 1000L,
        name = "name",
        slug = "slug",
        description = "description"
    )

    private fun generateLeague() = League(
        id = 1000L,
        imageUrl = "imageUrl",
        name = "name",
        slug = "slug",
        url = "url"
    )

    private fun generateListOpponent() = listOf(
        Opponent(
            opponent = generateTeam(),
            type = "type"
        )
    )

    private fun generateTeam() = Team(
        id = 1000L,
        imageUrl = "imageUrl",
        name = "name",
        slug = "slug",
        location = "location"
    )
}