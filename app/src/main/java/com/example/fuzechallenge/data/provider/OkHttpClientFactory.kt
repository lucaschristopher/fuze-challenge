package com.example.fuzechallenge.data.provider

import com.example.fuzechallenge.BuildConfig
import com.example.fuzechallenge.core.constants.AUTHORIZATION
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

object OkHttpClientFactory {

    fun build(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    }
}

internal class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder().apply {
            addHeader(AUTHORIZATION, "Bearer ${BuildConfig.API_KEY}")
        }
        return chain.proceed(builder.build())
    }
}
