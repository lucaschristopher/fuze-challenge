package com.example.fuzechallenge.data.datasource.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.fuzechallenge.core.constants.PAGE_SIZE
import com.example.fuzechallenge.core.util.mapToCustomError
import com.example.fuzechallenge.data.model.detail.GangResponse
import com.example.fuzechallenge.data.paging.AppPagingSource
import com.example.fuzechallenge.data.service.AppService
import com.example.fuzechallenge.domain.model.Match
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(
    private val service: AppService
) : RemoteDataSource {

    override fun getMatches(): Flow<PagingData<Match>> {
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
}