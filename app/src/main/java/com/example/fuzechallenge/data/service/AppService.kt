package com.example.fuzechallenge.data.service

import com.example.fuzechallenge.data.model.MatchResponse
import com.example.fuzechallenge.data.model.detail.GangResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppService {

    @GET("csgo/matches")
    suspend fun getMatches(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int,
        @Query("sort") sort: String,
    ): List<MatchResponse>

    @GET("teams/{id}")
    suspend fun getGangById(
        @Path("id") id: String,
    ): GangResponse
}