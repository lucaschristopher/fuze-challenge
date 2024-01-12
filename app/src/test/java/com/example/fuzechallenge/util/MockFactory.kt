package com.example.fuzechallenge.util

import com.example.fuzechallenge.commons.constants.Constants.DEFAULT_ID
import com.example.fuzechallenge.commons.constants.Constants.EMPTY_STRING
import com.example.fuzechallenge.data.model.LeagueResponse
import com.example.fuzechallenge.data.model.MatchResponse
import com.example.fuzechallenge.data.model.OpponentResponse
import com.example.fuzechallenge.data.model.SerieResponse
import com.example.fuzechallenge.data.model.TeamResponse
import com.example.fuzechallenge.domain.model.League
import com.example.fuzechallenge.domain.model.Match
import com.example.fuzechallenge.domain.model.Opponent
import com.example.fuzechallenge.domain.model.Serie
import com.example.fuzechallenge.domain.model.Team

// Data

internal val serieResponseMock = SerieResponse(
    id = DEFAULT_ID,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    description = EMPTY_STRING
)

internal val leagueResponseMock = LeagueResponse(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    url = EMPTY_STRING
)

internal val teamResponseMock = TeamResponse(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    location = EMPTY_STRING
)

internal val opponentResponseMock = OpponentResponse(
    opponent = teamResponseMock,
    type = EMPTY_STRING
)

internal val matchResponseMock = MatchResponse(
    id = DEFAULT_ID,
    scheduledAt = EMPTY_STRING,
    status = EMPTY_STRING,
    serie = serieResponseMock,
    league = leagueResponseMock,
    opponents = listOf(opponentResponseMock)
)

// Domain

internal val serieMock = Serie(
    id = DEFAULT_ID,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    description = EMPTY_STRING
)

internal val leagueMock = League(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    url = EMPTY_STRING
)

internal val teamMock = Team(
    id = DEFAULT_ID,
    imageUrl = EMPTY_STRING,
    name = EMPTY_STRING,
    slug = EMPTY_STRING,
    location = EMPTY_STRING
)

internal val opponentMock = Opponent(
    opponent = teamMock,
    type = EMPTY_STRING
)

internal val matchMock = Match(
    id = DEFAULT_ID,
    scheduledAt = EMPTY_STRING,
    status = EMPTY_STRING,
    serie = serieMock,
    league = leagueMock,
    opponents = listOf(opponentMock)
)
