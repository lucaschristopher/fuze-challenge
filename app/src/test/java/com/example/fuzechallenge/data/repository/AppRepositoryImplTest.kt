package com.example.fuzechallenge.data.repository

import androidx.paging.PagingData
import com.example.fuzechallenge.data.datasource.remote.RemoteDataSource
import com.example.fuzechallenge.util.PagingUtil.generateMatch
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertSame

@ExperimentalCoroutinesApi
class AppRepositoryImplTest {

    @MockK
    private val remoteDataSource: RemoteDataSource = mockk(relaxed = true)

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    private fun setupRepository() = AppRepositoryImpl(
        remoteDataSource,
        testDispatcher
    )

    @Test
    fun `getMatches Should return a flow list match when remoteDataSource getMatches return a flow list match`() =
        runTest {
            // Given
            val pagingDataMatchFlow = flowOf(PagingData.from(listOf(generateMatch())))
            val repository = setupRepository()

            // When
            coEvery {
                remoteDataSource.getMatches()
            } returns pagingDataMatchFlow
            val result = repository.getMatches()

            // Then
            assertSame(expected = pagingDataMatchFlow.first(), actual = result.first())
        }
}