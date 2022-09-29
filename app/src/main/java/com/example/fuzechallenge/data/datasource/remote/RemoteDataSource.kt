package com.example.fuzechallenge.data.datasource.remote

import androidx.paging.PagingData
import com.example.fuzechallenge.data.model.detail.GangResponse
import com.example.fuzechallenge.domain.model.Match
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getMatches(): Flow<PagingData<Match>>
    suspend fun getGangById(id: String): Flow<GangResponse>
}