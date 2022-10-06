package com.example.fuzechallenge.data.datasource.remote

import androidx.paging.PagingData
import com.example.fuzechallenge.data.model.MatchResponse
import com.example.fuzechallenge.data.model.detail.GangResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getMatches(): Flow<PagingData<MatchResponse>>
    suspend fun getGangById(id: String): Flow<GangResponse>
    suspend fun getTeamsInfo(teamsId: List<Long>): Flow<List<GangResponse>>
}