package com.example.fuzechallenge.data.provider

import com.example.fuzechallenge.core.constants.DEFAULT_TIME_VALUE
import com.example.fuzechallenge.data.provider.NetworkProvider.cache
import com.example.fuzechallenge.data.provider.interceptor.OfflineInterceptor
import com.example.fuzechallenge.data.provider.interceptor.OnlineInterceptor
import com.example.fuzechallenge.data.provider.interceptor.RequestInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object OkHttpClientFactory {

    fun build(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addInterceptor(OfflineInterceptor())
            .addNetworkInterceptor(OnlineInterceptor())
            .setupTimeout()
            .setupCache()
            .build()
    }

    private fun OkHttpClient.Builder.setupTimeout() = apply {
        readTimeout(DEFAULT_TIME_VALUE, TimeUnit.SECONDS)
        writeTimeout(DEFAULT_TIME_VALUE, TimeUnit.SECONDS)
        connectTimeout(DEFAULT_TIME_VALUE, TimeUnit.SECONDS)
    }

    private fun OkHttpClient.Builder.setupCache() = apply {
        cache(cache)
    }
}
