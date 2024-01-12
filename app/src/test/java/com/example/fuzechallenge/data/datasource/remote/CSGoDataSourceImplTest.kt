package com.example.fuzechallenge.data.datasource.remote

import com.example.fuzechallenge.commons.constants.Constants.DEFAULT_ID
import com.example.fuzechallenge.data.service.CSGoService
import com.example.fuzechallenge.util.matchResponseMock
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CSGoDataSourceImplTest {

    private val service: CSGoService = mockk(relaxed = true)
    private lateinit var remoteDataSource: CSGoDataSource

    @Before
    fun setUp() {
        remoteDataSource = CSGoDataSourceImpl(service)
    }

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `when getMatchById is called then returns success`() = runTest {
        val matchId = DEFAULT_ID.toString()

        coEvery {
            service.getMatchById(matchId)
        } returns matchResponseMock

        val result = remoteDataSource.getMatchById(matchId)

        result.collect {
            Assert.assertNotNull(it)
            Assert.assertEquals(it, matchResponseMock)
        }
    }
}
