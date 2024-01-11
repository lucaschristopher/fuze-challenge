package com.example.fuzechallenge.data.service

import com.example.fuzechallenge.data.model.GangResponse
import com.example.fuzechallenge.data.model.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface CSGoService {

    @GET("$CSGO/$MATCHES")
    suspend fun getMatches(
        @Query(PAGE) page: Int,
        @Query(PER_PAGE) pageSize: Int,
        @Query(SORT) sort: String,
    ): List<MatchResponse>

    @GET("$TEAMS/{$ID}")
    suspend fun getGangById(@Path(ID) id: String): GangResponse

    private companion object {
        const val CSGO = "csgo"
        const val MATCHES = "matches"
        const val PAGE = "page"
        const val PER_PAGE = "per_page"
        const val SORT = "sort"
        const val TEAMS = "teams"
        const val ID = "id"
    }
}
