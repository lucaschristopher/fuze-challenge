package com.example.fuzechallenge.data.repository

import androidx.paging.PagingData
import com.example.fuzechallenge.core.constants.DEFAULT_ID
import com.example.fuzechallenge.core.constants.INITIAL_INDEX
import com.example.fuzechallenge.core.constants.ONE
import com.example.fuzechallenge.core.constants.TWO
import com.example.fuzechallenge.data.datasource.remote.RemoteDataSource
import com.example.fuzechallenge.data.model.MatchResponse
import com.example.fuzechallenge.data.model.detail.GangResponse
import com.example.fuzechallenge.data.model.detail.toDomainModel
import com.example.fuzechallenge.domain.model.Match
import com.example.fuzechallenge.util.gangResponseMock
import com.example.fuzechallenge.util.matchResponseMock
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class AppRepositoryImplTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    @MockK
    private val remoteDataSource: RemoteDataSource = mockk(relaxed = true)

    private val remoteDataSourceFake = RemoteDataSourceFake()

    private fun setupRepository() = AppRepositoryImpl(
        remoteDataSourceFake, testDispatcher
    )

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `getMatches should return a flow when remoteDataSource getMatches return a flow list match`() =
        runTest {
            val mockedList = mutableListOf<PagingData<Match>>()
            val repository = setupRepository()

            // In this example, we are collecting these values
            // into a list and making declarations in the content.
            val collectJob = launch(testDispatcher) {
                repository.getMatches().toList(mockedList)
            }

            remoteDataSourceFake.emit(matchResponseMock)
            assertEquals(ONE, mockedList.size)

            // Assert the number of items collected
            remoteDataSourceFake.emit(matchResponseMock)
            assertEquals(TWO, mockedList.size)

            collectJob.cancel()
        }

    @Test
    fun `getTeamsInfo should return a flow when remoteDataSource getTeamsInfo return a flow item`() =
        runTest {
            // Given
            val mockedIdList = listOf(DEFAULT_ID, DEFAULT_ID)
            val dataFlow = flowOf(listOf(gangResponseMock))
            val repository = setupRepository()

            // When
            coEvery {
                remoteDataSource.getTeamsInfo(mockedIdList)
            } returns dataFlow

            val result = repository.getTeamsInfo(mockedIdList)

            // Then
            val expected = dataFlow.first().map { it.toDomainModel() }[INITIAL_INDEX].id
            val actual = result.first()[INITIAL_INDEX].id

            assertEquals(dataFlow.first().size, result.first().size)
            assertEquals(expected, actual)
        }
}

// When using this dummy implementation in a test, it is possible to create a collection coroutine
// that will continuously receive values from the Repository.
class RemoteDataSourceFake : RemoteDataSource {
    private val flow = MutableSharedFlow<PagingData<MatchResponse>>()

    suspend fun emit(value: MatchResponse) = flow.emit(PagingData.from(listOf(value)))

    override fun getMatches(): Flow<PagingData<MatchResponse>> = flow

    override suspend fun getGangById(id: String): Flow<GangResponse> = flowOf(gangResponseMock)

    override suspend fun getTeamsInfo(teamsId: List<Long>): Flow<List<GangResponse>> = flowOf(
        listOf(gangResponseMock)
    )
}