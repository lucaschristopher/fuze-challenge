package com.example.fuzechallenge.domain.usecase

import app.cash.turbine.test
import com.example.fuzechallenge.core.constants.DEFAULT_ID
import com.example.fuzechallenge.data.repository.AppRepositoryImpl
import com.example.fuzechallenge.util.gangMock
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class GetTeamsInfoUseCaseTest {

    @MockK
    private val repository: AppRepositoryImpl = mockk(relaxed = true)
    private val getTeamsInfoUseCase = GetTeamsInfoUseCase(repository)

    @Test
    fun `should get team info from repository`() = runTest {
        val mockedIdList = listOf(DEFAULT_ID, DEFAULT_ID)
        val mockedGangList = listOf(gangMock, gangMock)
        val dataFlow = flowOf(mockedGangList)

        every {
            runBlocking {
                repository.getTeamsInfo(mockedIdList)
            }
        } answers { dataFlow }

        getTeamsInfoUseCase.invoke(mockedIdList).test {
            assertEquals(
                dataFlow.first(),
                awaitItem()
            )
            awaitComplete()
        }
    }
}