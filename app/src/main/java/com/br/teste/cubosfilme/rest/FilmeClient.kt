package com.br.teste.cubosfilme.rest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://api.themoviedb.org/3/"

class FilmeClient {
    companion object {
        private val httpClient = OkHttpClient
            .Builder()
            .connectTimeout(3, TimeUnit.MINUTES)
            .readTimeout(3, TimeUnit.MINUTES)
            .addNetworkInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().header("Content-Type" , "application/json").build())
            }
            .build()

        private val builderV1 = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        fun <TService> createClientV1(serviceClass: Class<TService>): TService {
            val retrofit = builderV1.client(httpClient).build()
            return retrofit.create(serviceClass)
        }
    }
}