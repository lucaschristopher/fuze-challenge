package com.example.fuzechallenge.data.repository

import androidx.paging.PagingData
import com.example.fuzechallenge.domain.model.Match
import com.example.fuzechallenge.domain.model.detail.Gang
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getMatches(): Flow<PagingData<Match>>
    suspend fun getGangById(id: String): Flow<Gang>
}