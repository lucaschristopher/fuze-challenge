package com.example.fuzechallenge.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.example.fuzechallenge.commons.constants.Constants.DEFAULT_ID
import com.example.fuzechallenge.data.datasource.remote.CSGoDataSource
import com.example.fuzechallenge.data.mapper.toDomain
import com.example.fuzechallenge.domain.repository.CSGoRepository
import com.example.fuzechallenge.util.matchResponseMock
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CSGoRepositoryImplTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private val remoteDataSource: CSGoDataSource = mockk(relaxed = true)
    private lateinit var repository: CSGoRepository

    @Before
    fun setUp() {
        repository = CSGoRepositoryImpl(remoteDataSource, testDispatcher)
    }

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `when getMatches is called then should returns success`() = runTest {
        val mockedList = listOf(matchResponseMock, matchResponseMock)
        val expected = flowOf(PagingData.from(mockedList))

        coEvery {
            remoteDataSource.getMatches()
        } returns expected

        val result = repository.getMatches()

        result.collect {
            assertNotNull(it)
        }
    }

    @Test
    fun `when getMatchDetails is called should return a flow item`() =
        runTest {
            // Given
            val matchId = DEFAULT_ID.toString()

            // When
            coEvery {
                remoteDataSource.getMatchById(matchId)
            } returns flowOf(matchResponseMock)

            val result = repository.getMatchById(matchId)

            // Then
            result.collect {
                assertEquals(matchResponseMock.toDomain().id, it.id)
            }
        }

    @Test
    fun `when getMatchDetails is called then returns error`() = runTest {
        // Given
        val expectedError = Exception("Deu negado, fera!")
        val matchId = DEFAULT_ID.toString()

        // When
        coEvery {
            remoteDataSource.getMatchById(matchId)
        } returns flow { throw expectedError }

        val result = repository.getMatchById(matchId)

        // Then
        result.catch {
            assertEquals(expectedError.message, it.message)
        }.collect()
    }
}
