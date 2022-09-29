package com.example.fuzechallenge.data.repository

import androidx.paging.PagingData
import com.example.fuzechallenge.domain.model.Match
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getMatches(): Flow<PagingData<Match>>
}