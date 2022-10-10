package com.example.fuzechallenge.util

import com.example.fuzechallenge.core.constants.DEFAULT_ID
import com.example.fuzechallenge.core.constants.EMPTY_STRING
import com.example.fuzechallenge.data.model.*
import com.example.fuzechallenge.data.model.detail.GangResponse
import com.example.fuzechallenge.data.model.detail.PlayerResponse
import com.example.fuzechallenge.domain.model.*
import com.example.fuzechallenge.domain.model.detail.Gang
import com.example.fuzechallenge.domain.model.detail.Player


// Data Models Mock
val playerResponseMock = PlayerResponse(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    slug = EMPTY_STRING,
    firstName = EMPTY_STRING,
    lastName = EMPTY_STRING
)

val gangResponseMock = GangResponse(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    players = listOf(playerResponseMock)
)

val serieResponseMock = SerieResponse(
    id = DEFAULT_ID,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    description = EMPTY_STRING
)

val leagueResponseMock = LeagueResponse(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    url = EMPTY_STRING
)

val teamResponseMock = TeamResponse(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    location = EMPTY_STRING
)

val opponentResponseMock = OpponentResponse(
    opponent = teamResponseMock,
    type = EMPTY_STRING
)

val matchResponseMock = MatchResponse(
    id = DEFAULT_ID,
    scheduledAt = EMPTY_STRING,
    status = EMPTY_STRING,
    serie = serieResponseMock,
    league = leagueResponseMock,
    opponents = listOf(opponentResponseMock)
)

// Domain Models Mock

val serieMock = Serie(
    id = DEFAULT_ID,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    description = EMPTY_STRING
)

val leagueMock = League(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    url = EMPTY_STRING
)

val teamMock = Team(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    location = EMPTY_STRING
)

val opponentMock = Opponent(
    opponent = teamMock,
    type = EMPTY_STRING
)

val opponentUiModelMock = opponentMock.toUiModel()

val matchMock = Match(
    id = DEFAULT_ID,
    scheduledAt = EMPTY_STRING,
    status = EMPTY_STRING,
    serie = serieMock,
    league = leagueMock,
    opponents = listOf(opponentMock)
)

val playerMock = Player(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    slug = EMPTY_STRING,
    firstName = EMPTY_STRING,
    lastName = EMPTY_STRING
)


val gangMock = Gang(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    players = listOf(playerMock)
)