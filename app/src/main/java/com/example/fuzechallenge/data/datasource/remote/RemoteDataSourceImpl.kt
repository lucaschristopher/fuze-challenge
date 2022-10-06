package com.example.fuzechallenge.data.datasource.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.fuzechallenge.core.constants.PAGE_SIZE
import com.example.fuzechallenge.core.util.mapToCustomError
import com.example.fuzechallenge.data.model.MatchResponse
import com.example.fuzechallenge.data.model.detail.GangResponse
import com.example.fuzechallenge.data.paging.AppPagingSource
import com.example.fuzechallenge.data.service.AppService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(
    private val service: AppService
) : RemoteDataSource {

    override fun getMatches(): Flow<PagingData<MatchResponse>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = {
                AppPagingSource(this.service)
            }
        ).flow
    }

    override suspend fun getGangById(id: String): Flow<GangResponse> = flow {
        val response = service.getGangById(id)
        emit(response)
    }.mapToCustomError()

    override suspend fun getTeamsInfo(teamsId: List<Long>): Flow<List<GangResponse>> = flow {
        val teamsInfo = mutableListOf<GangResponse>()

        teamsId.forEach { id ->
            getGangById(id.toString()).collect { response ->
                teamsInfo.add(response)
            }
        }
        emit(teamsInfo)
    }.mapToCustomError()
}