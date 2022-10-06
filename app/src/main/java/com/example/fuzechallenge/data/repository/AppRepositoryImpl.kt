package com.example.fuzechallenge.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.example.fuzechallenge.data.datasource.remote.RemoteDataSource
import com.example.fuzechallenge.data.model.detail.toDomainModel
import com.example.fuzechallenge.data.model.toDomainModel
import com.example.fuzechallenge.domain.model.Match
import com.example.fuzechallenge.domain.model.detail.Gang
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AppRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val dispatcher: CoroutineDispatcher
) : AppRepository {

    override fun getMatches(): Flow<PagingData<Match>> = flow {
        remoteDataSource.getMatches().collect { result ->
            emit(result.map { it.toDomainModel() })
        }
    }.flowOn(dispatcher)

    override suspend fun getTeamsInfo(teamsId: List<Long>): Flow<List<Gang>> = flow {
        remoteDataSource.getTeamsInfo(teamsId).collect { result ->
            emit(result.map { it.toDomainModel() })
        }
    }.flowOn(dispatcher)
}