package com.example.fuzechallenge.data.datasource.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.fuzechallenge.commons.constants.Constants.INITIAL_PAGE
import com.example.fuzechallenge.commons.constants.Constants.ONE
import com.example.fuzechallenge.commons.constants.Constants.PAGE_SIZE
import com.example.fuzechallenge.commons.constants.Constants.SORT_PARAM
import com.example.fuzechallenge.data.model.MatchResponse
import com.example.fuzechallenge.data.service.CSGoService
import javax.inject.Inject

internal class CSGoPagingSource @Inject constructor(
    private val service: CSGoService
) : PagingSource<Int, MatchResponse>() {

    override fun getRefreshKey(state: PagingState<Int, MatchResponse>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MatchResponse> {
        return try {
            val nextPage = params.key ?: INITIAL_PAGE
            val matchList = service.getMatches(nextPage, PAGE_SIZE, SORT_PARAM)
            LoadResult.Page(
                data = matchList,
                prevKey = params.key,
                nextKey = params.key?.plus(ONE) ?: INITIAL_PAGE.plus(ONE)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }
}
