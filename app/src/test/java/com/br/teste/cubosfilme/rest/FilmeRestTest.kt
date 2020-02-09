package com.br.teste.cubosfilme.rest

import com.br.teste.cubosfilme.model.Filme

object FilmeRestTest {

    fun filmesPorGeneros(apiToken: String, idioma: String, generoId: Int, success: (Filme) -> Unit, failure: (Throwable) -> Unit){

        val consultorApi = FilmeClient.createClientV1(FilmeAPI::class.java).filmesPorGenero(apiToken, idioma, generoId)

        consultorApi.enqueue(callback { response, throwable ->
            response?.let {
                if (response.isSuccessful) {
                    it.body()?.let {
                        success(it)
                    }
                } else {

                }
            }
            throwable?.let {
                failure(it)
            }
        })
    }

    fun filmesPorTitulo(apiToken: String, idioma: String, titulo: String,
                        success: (Filme) -> Unit, failure: (Throwable) -> Unit){

        val consultorApi = FilmeClient.createClientV1(FilmeAPI::class.java).filmesPorTitulo(apiToken, idioma, titulo)

        consultorApi.enqueue(callback { response, throwable ->
            response?.let {
                if (response.isSuccessful) {
                    it.body()?.let {
                        success(it)
                    }
                } else {
                }
            }
            throwable?.let {
                failure(it)
            }
        })
    }
}