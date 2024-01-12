package com.example.fuzechallenge.presentation.list.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingData
import androidx.paging.map
import com.example.fuzechallenge.domain.usecase.list.GetMatchesUseCase
import com.example.fuzechallenge.util.matchMock
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MatchListViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    private val getMatchesUseCase: GetMatchesUseCase = mockk(relaxed = true)

    private lateinit var viewModel: MatchListViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `when viewModel is created, then call getMatches method`() = runTest {
        coEvery {
            getMatchesUseCase.invoke()
        } returns flowOf(PagingData.from(listOf(matchMock, matchMock)))

        viewModel = MatchListViewModel(getMatchesUseCase)

        viewModel.state.value.map {
            Assert.assertEquals(it.id, matchMock.id)
            Assert.assertEquals(it.opponents.size, matchMock.opponents.size)
        }
    }
}
