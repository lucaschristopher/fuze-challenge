package com.example.fuzechallenge.data.datasource.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.fuzechallenge.data.datasource.remote.paging.CSGoPagingSource
import com.example.fuzechallenge.data.model.MatchResponse
import com.example.fuzechallenge.data.service.CSGoService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val PAGE_SIZE: Int = 20

internal class CSGoDataSourceImpl @Inject constructor(
    private val service: CSGoService
) : CSGoDataSource {
    override suspend fun getMatches(): Flow<PagingData<MatchResponse>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = {
                CSGoPagingSource(this.service)
            }
        ).flow
    }

    override suspend fun getMatchById(id: String): Flow<MatchResponse> = flow {
        val response = service.getMatchById(id)
        emit(response)
    }
}
