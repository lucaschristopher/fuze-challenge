package com.example.fuzechallenge.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingData
import app.cash.turbine.test
import com.example.fuzechallenge.core.constants.ONE
import com.example.fuzechallenge.data.repository.AppRepository
import com.example.fuzechallenge.domain.usecase.GetMatchesUseCase
import com.example.fuzechallenge.util.matchMock
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    private val repository = mockk<AppRepository>()

    private val getMatchesUseCase = GetMatchesUseCase(repository)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
    }

    @Test
    fun `repository should returns not null content when viewModel getMatches is called`() =
        runTest(testDispatcher) {
            val viewModel = HomeViewModel(getMatchesUseCase)
            val dataFlow = flowOf(PagingData.from(listOf(matchMock)))

            coEvery { repository.getMatches() } answers { dataFlow }

            viewModel.matchList().test {
                assertNotNull(awaitItem())
                assertEquals(ONE, dataFlow.toList().size)
            }
        }
}