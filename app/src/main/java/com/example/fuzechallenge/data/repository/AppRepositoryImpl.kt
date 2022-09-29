package com.example.fuzechallenge.data.repository

import androidx.paging.PagingData
import com.example.fuzechallenge.data.datasource.remote.RemoteDataSource
import com.example.fuzechallenge.data.model.detail.toDomainModel
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

    override fun getMatches(): Flow<PagingData<Match>> {
        return this.remoteDataSource.getMatches().flowOn(dispatcher)
    }

    override suspend fun getGangById(id: String): Flow<Gang> = flow {
        remoteDataSource.getGangById(id).collect { result ->
            emit(result.toDomainModel())
        }
    }.flowOn(dispatcher)
}