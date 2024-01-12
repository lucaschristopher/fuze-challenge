package com.example.fuzechallenge.domain.usecase.list

import androidx.paging.PagingData
import androidx.paging.map
import com.example.fuzechallenge.domain.model.Match
import com.example.fuzechallenge.domain.repository.CSGoRepository
import com.example.fuzechallenge.util.matchMock
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class GetMatchesUseCaseImplTest {

    private val repository: CSGoRepository = mockk(relaxed = true)
    private lateinit var getMatchesUseCase: GetMatchesUseCase

    @Before
    fun setup() {
        getMatchesUseCase = GetMatchesUseCaseImpl(repository)
    }

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `should get matches from repository`() = runTest {
        val expected = PagingData.empty<Match>()
        coEvery {
            repository.getMatches()
        } returns flowOf(expected)

        getMatchesUseCase.invoke().collect { paging ->
            assertNotNull(paging)
            paging.map {
                assertEquals(it.id, matchMock.id)
                assertEquals(it.opponents.size, matchMock.opponents.size)
            }
        }
    }
}