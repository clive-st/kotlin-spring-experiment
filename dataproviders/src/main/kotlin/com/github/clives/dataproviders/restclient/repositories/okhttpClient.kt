package com.github.clives.dataproviders.restclient.repositories

import okhttp3.ConnectionPool
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import java.util.concurrent.TimeUnit

class okhttpClient(val keyInterceptor: ApiKeyInterceptor) {


    val HTTP_MAX_IDLE = 20
    val HTTP_KEEP_ALIVE = 20L
    val HTTP_CONNECTION_TIMEOUT = 30L

    val builder = OkHttpClient.Builder();
    val okHttpConnectionPool = ConnectionPool(HTTP_MAX_IDLE, HTTP_KEEP_ALIVE,
            TimeUnit.SECONDS);

    fun getRestTemplate(): RestTemplate {
        val restTemplate = RestTemplate();
        builder.connectionPool(okHttpConnectionPool)
        builder.connectTimeout(HTTP_CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);

        class ApiKeyInterceptor(private val apiKey: String) : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                return chain.proceed(
                        with(chain.request()) {
                            newBuilder().url(
                                    url.newBuilder()
                                            .addQueryParameter("apikey", apiKey)
                                            .build()
                            ).build()
                        }
                )
            }
        }
        builder.addInterceptor(ApiKeyInterceptor())
        restTemplate.setRequestFactory(OkHttp3ClientHttpRequestFactory(builder.build()));
        return restTemplate;
    }
}