package com.example.fuzechallenge.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.example.fuzechallenge.data.datasource.remote.CSGoDataSource
import com.example.fuzechallenge.data.mapper.toDomain
import com.example.fuzechallenge.domain.model.Gang
import com.example.fuzechallenge.domain.model.Match
import com.example.fuzechallenge.domain.repository.CSGoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class CSGoRepositoryImpl @Inject constructor(
    private val remoteDataSource: CSGoDataSource,
    private val dispatcher: CoroutineDispatcher
) : CSGoRepository {

    override suspend fun getMatches(): Flow<PagingData<Match>> = flow {
        remoteDataSource.getMatches().collect { result ->
            emit(result.map { it.toDomain() })
        }
    }.flowOn(dispatcher)

    override suspend fun getTeamsDetails(teamsId: List<Long>): Flow<List<Gang>> = flow {
        remoteDataSource.getTeamsDetails(teamsId).collect { result ->
            emit(result.map { it.toDomain() })
        }
    }.flowOn(dispatcher)
}
