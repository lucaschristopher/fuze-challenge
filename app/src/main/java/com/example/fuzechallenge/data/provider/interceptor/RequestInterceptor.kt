package com.example.fuzechallenge.data.provider.interceptor

import com.example.fuzechallenge.BuildConfig
import com.example.fuzechallenge.core.constants.AUTHORIZATION
import com.example.fuzechallenge.core.constants.DEFAULT_TIME_VALUE
import com.example.fuzechallenge.data.provider.NetworkProvider
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

class OfflineInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (NetworkProvider.hasNetwork() == false) {
            val maxStale =
                DEFAULT_TIME_VALUE * DEFAULT_TIME_VALUE // Offline cache available for 1 hour

            request = request.newBuilder()
                .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                .removeHeader("Pragma")
                .build()
        }

        return chain.proceed(request)
    }
}

class OnlineInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val maxAge = DEFAULT_TIME_VALUE

        return response.newBuilder()
            .header("Cache-Control", "public, max-age=$maxAge")
            .removeHeader("Pragma")
            .build()
    }
}
