package com.example.fuzechallenge.presentation.detail.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.example.fuzechallenge.commons.constants.Constants.DEFAULT_ID
import com.example.fuzechallenge.domain.usecase.detail.GetMatchByIdUseCase
import com.example.fuzechallenge.presentation.commons.model.CSGoViewModelState
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
class MatchDetailsViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    private val getMatchByIdUseCase: GetMatchByIdUseCase = mockk(relaxed = true)

    private lateinit var savedStateHandle: SavedStateHandle

    private lateinit var viewModel: MatchDetailsViewModel

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
        val matchId = DEFAULT_ID.toString()

        coEvery {
            getMatchByIdUseCase.invoke(matchId)
        } returns flowOf(matchMock)

        savedStateHandle = SavedStateHandle(mapOf("matchId" to "0"))
        viewModel = MatchDetailsViewModel(getMatchByIdUseCase, savedStateHandle)

        Assert.assertTrue(viewModel.state.value is CSGoViewModelState.Success)
        Assert.assertEquals(
            (viewModel.state.value as CSGoViewModelState.Success).match.id,
            matchMock.id
        )
    }
}
