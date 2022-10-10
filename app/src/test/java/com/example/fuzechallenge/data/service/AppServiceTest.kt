package com.example.fuzechallenge.data.service

import com.example.fuzechallenge.core.constants.EMPTY_STRING
import com.example.fuzechallenge.core.constants.INITIAL_PAGE
import com.example.fuzechallenge.core.constants.PAGE_SIZE
import com.example.fuzechallenge.data.model.detail.GangResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import retrofit2.HttpException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException

private const val get_matches_response = "get_matches_success_response.json"
private const val get_gang_by_id_response = "get_gang_by_id_success_response.json"

class AppServiceTest : ServiceBaseTests() {

    @Test
    fun `should get matches when server gives success response`() = runBlocking {
        // Given
        val expectedResponse = getExpectedResponse(
            get_matches_response,
            List::class.java
        )
        getResponse(get_matches_response, HttpURLConnection.HTTP_OK)

        // When
        val result =
            service.getMatches(INITIAL_PAGE, PAGE_SIZE, EMPTY_STRING)

        // Then
        Assert.assertEquals(expectedResponse.size, result.size)
    }

    @Test
    fun `should get gang when server gives success response`() = runBlocking {
        // Given
        val expectedResponse =
            getExpectedResponse(get_gang_by_id_response, GangResponse::class.java)
        getResponse(get_gang_by_id_response, HttpURLConnection.HTTP_OK)

        // When
        val result = service.getGangById(EMPTY_STRING)

        // Then
        Assert.assertEquals(expectedResponse.id, result.id)
    }

    @Test
    fun `should throw client exception when server sends 4xx response`(): Unit = runBlocking {
        Assert.assertThrows(HttpException::class.java) {
            runBlocking {
                getResponse(
                    get_matches_response,
                    HttpURLConnection.HTTP_BAD_REQUEST
                )
                service.getMatches(INITIAL_PAGE, PAGE_SIZE, EMPTY_STRING)
            }
        }
    }

    @Test
    fun `should throw no network exception in case of timeout`() {
        Assert.assertThrows(SocketTimeoutException::class.java) {
            runBlocking {
                getTimeout()
                service.getMatches(INITIAL_PAGE, PAGE_SIZE, EMPTY_STRING)
            }
        }
    }
}