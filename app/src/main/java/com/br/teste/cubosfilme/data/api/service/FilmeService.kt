package com.br.teste.cubosfilme.data.api.service

import com.br.teste.cubosfilme.data.database.Filme
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmeService {

    @GET("discover/movie")
    fun filmes(
        @Query("api_key") apiToken: String,
        @Query("language") idioma: String,
        @Query("sort_by") ordenar: String,
        @Query("include_adult") incluirAdulto: Boolean,
        @Query("include_video") incluirVideo: Boolean,
        @Query("page") pagina: Int
    ): Call<Filme>
}