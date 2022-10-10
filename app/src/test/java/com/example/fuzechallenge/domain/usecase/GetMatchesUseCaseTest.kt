package com.example.fuzechallenge.domain.usecase

import app.cash.turbine.test
import com.example.fuzechallenge.data.repository.AppRepositoryImpl
import com.example.fuzechallenge.util.matchMock
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class GetMatchesUseCaseTest {

    @MockK
    private val repository: AppRepositoryImpl = mockk(relaxed = true)
    private val getMatchesUseCase = GetMatchesUseCase(repository)

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `should get matches from repository`() = runTest {
        every {
            runBlocking {
                repository.getMatches()
            }
        } answers {
            flow { listOf(matchMock) }
        }

        getMatchesUseCase.invoke().test {
            assertEquals(listOf(matchMock).first(), matchMock)
            awaitComplete()
        }
    }
}