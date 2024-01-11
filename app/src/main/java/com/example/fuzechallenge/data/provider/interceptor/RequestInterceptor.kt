package com.example.fuzechallenge.data.provider.interceptor

import com.example.fuzechallenge.BuildConfig
import com.example.fuzechallenge.commons.constants.Constants.AUTHORIZATION
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder().apply {
            addHeader(AUTHORIZATION, "Bearer ${BuildConfig.API_KEY}")
        }
        return chain.proceed(builder.build())
    }
}
