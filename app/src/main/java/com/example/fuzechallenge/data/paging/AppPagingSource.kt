package com.example.fuzechallenge.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.fuzechallenge.core.constants.INITIAL_PAGE
import com.example.fuzechallenge.core.constants.ONE
import com.example.fuzechallenge.core.constants.PAGE_SIZE
import com.example.fuzechallenge.core.constants.SORT_PARAM
import com.example.fuzechallenge.data.model.MatchResponse
import com.example.fuzechallenge.data.service.AppService

class AppPagingSource(
    private val service: AppService
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
                nextKey = params.key?.plus(ONE) ?: STARTING_PAGE_INDEX.plus(ONE)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = INITIAL_PAGE
    }
}