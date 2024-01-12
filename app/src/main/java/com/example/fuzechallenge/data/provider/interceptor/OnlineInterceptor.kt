package com.example.fuzechallenge.data.provider.interceptor

import com.example.fuzechallenge.commons.constants.Constants.DEFAULT_TIME_VALUE
import okhttp3.Interceptor
import okhttp3.Response

internal class OnlineInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        return response.newBuilder()
            .header(CACHE_CONTROL_NAME, CACHE_CONTROL_VALUE)
            .removeHeader(PRAGMA_NAME)
            .build()
    }

    private companion object {
        const val CACHE_CONTROL_NAME = "Cache-Control"
        const val CACHE_CONTROL_VALUE = "public, max-age=$DEFAULT_TIME_VALUE"
        const val PRAGMA_NAME = "public, max-age=$DEFAULT_TIME_VALUE"
    }
}
