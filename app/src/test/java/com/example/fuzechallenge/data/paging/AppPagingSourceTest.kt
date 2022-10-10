package com.example.fuzechallenge.data.paging

import androidx.paging.PagingSource
import com.example.fuzechallenge.core.constants.EMPTY_STRING
import com.example.fuzechallenge.core.constants.INITIAL_PAGE
import com.example.fuzechallenge.core.constants.TWO
import com.example.fuzechallenge.data.model.MatchResponse
import com.example.fuzechallenge.data.model.detail.GangResponse
import com.example.fuzechallenge.data.service.AppService
import com.example.fuzechallenge.util.gangResponseMock
import com.example.fuzechallenge.util.matchResponseMock
import io.mockk.MockKAnnotations
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AppPagingSourceTest {

    private val mockedList = listOf(matchResponseMock, matchResponseMock)

    private val fakeService = object : AppService {
        override suspend fun getMatches(
            page: Int,
            pageSize: Int,
            sort: String
        ): List<MatchResponse> = mockedList

        override suspend fun getGangById(id: String): GangResponse = gangResponseMock
    }

    @Before
    fun init() {
        MockKAnnotations.init(this, true)
    }

    @Test
    fun `should get same amount of result as specified in paging load`() = runTest {
        val response = fakeService.getMatches(
            page = INITIAL_PAGE,
            pageSize = INITIAL_PAGE,
            sort = EMPTY_STRING
        )

        val pagingSource = AppPagingSource(fakeService)

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