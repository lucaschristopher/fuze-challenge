package com.example.fuzechallenge.data.datasource.remote

import androidx.paging.PagingData
import com.example.fuzechallenge.data.model.GangResponse
import com.example.fuzechallenge.data.model.MatchResponse
import kotlinx.coroutines.flow.Flow

internal interface CSGoDataSource {
    suspend fun getMatches(): Flow<PagingData<MatchResponse>>
    suspend fun getGangById(id: String): Flow<GangResponse>
    suspend fun getTeamsDetails(teamsId: List<Long>): Flow<List<GangResponse>>
}
