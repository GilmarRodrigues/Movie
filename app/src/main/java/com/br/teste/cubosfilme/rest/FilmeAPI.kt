package com.br.teste.cubosfilme.rest

import com.br.teste.cubosfilme.model.Filme
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmeAPI {

    @GET("discover/movie")
    fun filmesPorGenero(@Query("api_key") apiToken: String,
                        @Query("language") idioma: String,
                        @Query("with_genres") generoId: Int): Call<Filme>

    @GET("search/movie")
    fun filmesPorTitulo(@Query("api_key") apiToken: String,
              @Query("language") idioma: String,
              @Query("query") titulo: String): Call<Filme>
}