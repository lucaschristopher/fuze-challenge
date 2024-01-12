package com.example.fuzechallenge.domain.repository

import androidx.paging.PagingData
import com.example.fuzechallenge.domain.model.Match
import kotlinx.coroutines.flow.Flow

internal interface CSGoRepository {
    suspend fun getMatches(): Flow<PagingData<Match>>
    suspend fun getMatchById(matchId: String): Flow<Match>
}
