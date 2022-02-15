package com.github.clives.dataproviders.restclient.repositories

import okhttp3.Interceptor
import okhttp3.Response
import org.springframework.beans.factory.annotation.Value


class ApiKeyInterceptor() : Interceptor {

    @Value("\${OMDb.apikeyl}")
    private val apikey: String? = null

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
                with(chain.request()) {
                    newBuilder().url(
                            url.newBuilder()
                                    .addQueryParameter("apikey", apikey)
                                    .build()
                    ).build()
                }
        )
    }
}