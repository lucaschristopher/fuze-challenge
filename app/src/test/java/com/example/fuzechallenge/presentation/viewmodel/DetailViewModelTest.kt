package com.example.fuzechallenge.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.example.fuzechallenge.core.constants.DEFAULT_ID
import com.example.fuzechallenge.data.repository.AppRepository
import com.example.fuzechallenge.domain.model.detail.Gang
import com.example.fuzechallenge.domain.model.toUiModel
import com.example.fuzechallenge.domain.usecase.GetTeamsInfoUseCase
import com.example.fuzechallenge.presentation.state.ViewState
import com.example.fuzechallenge.util.gangMock
import com.example.fuzechallenge.util.opponentMock
import com.example.fuzechallenge.util.opponentUiModelMock
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    private val repository = mockk<AppRepository>()

    private val getTeamsInfoUseCase = GetTeamsInfoUseCase(repository)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when getTeamsInfoUseCase returns empty list teamsInfo should be returns an error`() =
        runTest(testDispatcher) {
            val mockedIdList = listOf(DEFAULT_ID, DEFAULT_ID)
            val viewModel = DetailViewModel(getTeamsInfoUseCase)
            val dataFlow = flowOf(listOf<Gang>())

            coEvery { getTeamsInfoUseCase.invoke(mockedIdList) } answers { dataFlow }

            viewModel.getTeamsInfo(listOf(opponentMock.toUiModel()))
            viewModel.teamsInfo.test {
                assertTrue(awaitItem() is ViewState.Error)
            }
        }

    @Test
    fun `when getTeamsInfoUseCase returns content list teamsInfo should be returns success`() =
        runTest(testDispatcher) {
            val mockedIdList = listOf(DEFAULT_ID, DEFAULT_ID)
            val viewModel = DetailViewModel(getTeamsInfoUseCase)
            val dataFlow = flowOf(listOf(gangMock))

            coEvery { getTeamsInfoUseCase.invoke(mockedIdList) } answers { dataFlow }

            viewModel.getTeamsInfo(listOf(opponentUiModelMock, opponentUiModelMock))
            viewModel.teamsInfo.test {
                assertTrue(awaitItem() is ViewState.Success)
            }
        }
}