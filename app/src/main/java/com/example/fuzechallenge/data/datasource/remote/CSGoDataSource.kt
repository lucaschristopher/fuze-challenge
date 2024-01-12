package com.example.fuzechallenge.data.datasource.remote

import androidx.paging.PagingData
import com.example.fuzechallenge.data.model.MatchResponse
import kotlinx.coroutines.flow.Flow

internal interface CSGoDataSource {
    suspend fun getMatches(): Flow<PagingData<MatchResponse>>
    suspend fun getMatchById(id: String): Flow<MatchResponse>
}
