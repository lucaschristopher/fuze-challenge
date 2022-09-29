package com.example.fuzechallenge.data.service

import com.example.fuzechallenge.data.model.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AppService {

    @GET("matches")
    suspend fun getMatches(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int,
        @Query("sort") sort: String,
    ): List<MatchResponse>
}