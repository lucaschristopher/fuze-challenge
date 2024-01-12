package com.example.fuzechallenge.domain.usecase.detail

import com.example.fuzechallenge.commons.constants.Constants.DEFAULT_ID
import com.example.fuzechallenge.domain.repository.CSGoRepository
import com.example.fuzechallenge.util.matchMock
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetMatchByIdUseCaseImplTest {

    private val repository: CSGoRepository = mockk(relaxed = true)
    private lateinit var getMatchByIdUseCase: GetMatchByIdUseCase

    @Before
    fun setup() {
        getMatchByIdUseCase = GetMatchByIdUseCaseImpl(repository)
    }

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `should get match details from repository`() = runTest {
        val matchId = DEFAULT_ID.toString()

        coEvery {
            repository.getMatchById(matchId)
        } returns flowOf(matchMock)

        getMatchByIdUseCase.invoke(matchId).collect {
            Assert.assertNotNull(it)
            Assert.assertEquals(it.id, matchMock.id)
        }
    }
}