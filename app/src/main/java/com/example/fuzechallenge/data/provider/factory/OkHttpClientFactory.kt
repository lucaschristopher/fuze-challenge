package com.example.fuzechallenge.data.provider.factory

import com.example.fuzechallenge.commons.constants.Constants.DEFAULT_TIME_VALUE
import com.example.fuzechallenge.data.provider.interceptor.OnlineInterceptor
import com.example.fuzechallenge.data.provider.interceptor.RequestInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

internal object OkHttpClientFactory {

    fun build(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addNetworkInterceptor(OnlineInterceptor())
            .setupTimeout()
            .build()
    }

    private fun OkHttpClient.Builder.setupTimeout() = apply {
        readTimeout(DEFAULT_TIME_VALUE, TimeUnit.SECONDS)
        writeTimeout(DEFAULT_TIME_VALUE, TimeUnit.SECONDS)
        connectTimeout(DEFAULT_TIME_VALUE, TimeUnit.SECONDS)
    }
}
