package com.example.fuzechallenge.domain.repository

import androidx.paging.PagingData
import com.example.fuzechallenge.domain.model.Gang
import com.example.fuzechallenge.domain.model.Match
import kotlinx.coroutines.flow.Flow

interface CSGoRepository {
    suspend fun getMatches(): Flow<PagingData<Match>>
    suspend fun getTeamsDetails(teamsId: List<Long>): Flow<List<Gang>>
}
