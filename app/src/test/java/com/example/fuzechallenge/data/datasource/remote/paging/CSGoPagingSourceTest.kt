package com.example.fuzechallenge.data.datasource.remote.paging

import androidx.paging.PagingSource
import com.example.fuzechallenge.commons.constants.Constants.EMPTY_STRING
import com.example.fuzechallenge.commons.constants.Constants.INITIAL_PAGE
import com.example.fuzechallenge.commons.constants.Constants.TWO
import com.example.fuzechallenge.data.model.MatchResponse
import com.example.fuzechallenge.data.service.CSGoService
import com.example.fuzechallenge.util.matchResponseMock
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class CSGoPagingSourceTest {

    private val mockedList = listOf(matchResponseMock, matchResponseMock)

    private val fakeService = object : CSGoService {
        override suspend fun getMatches(
            page: Int,
            pageSize: Int,
            sort: String
        ): List<MatchResponse> = mockedList

        override suspend fun getMatchById(id: String) = matchResponseMock
    }

    @Test
    fun `should get same amount of result as specified in paging load`() = runTest {
        val response = fakeService.getMatches(
            page = INITIAL_PAGE,
            pageSize = INITIAL_PAGE,
            sort = EMPTY_STRING
        )

        val pagingSource = CSGoPagingSource(fakeService)

        assertEquals(
            PagingSource.LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = TWO
            ),
            pagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = mockedList.size,
                    placeholdersEnabled = false
                )
            )
        )
    }
}