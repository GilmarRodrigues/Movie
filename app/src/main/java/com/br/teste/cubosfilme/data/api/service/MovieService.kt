package com.br.teste.cubosfilme.data.api.service

import com.br.teste.cubosfilme.data.api.response.MovieListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("discover/movie")
    suspend fun movies(
        @Query("api_key") apiToken: String = "6c05f9965be289e35bb428a2bd4604a9",
        @Query("language") language: String = "pt-BR",
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("page") page: Int = 1
    ): Response<MovieListDto>
}