package com.br.teste.cubosfilme.retrofit.webclient

import android.util.Log
import com.br.teste.cubosfilme.model.Filme
import com.br.teste.cubosfilme.retrofit.AppRetrofit
import com.br.teste.cubosfilme.retrofit.service.FilmeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val REQUISICAO_NAO_SUCEDIDA = "Requisição não sucedida"
private const val PAGINA = 1
private const val API_TOKEN = "6c05f9965be289e35bb428a2bd4604a9"
private const val IDIOMA = "pt-BR"
private const val ORDENAR_DESCRECENTE = "popularity.desc"
private const val FILMES_ADULTOS = false
private const val FILMES_COM_VIDEO = false

class FilmeWebClient(private val service: FilmeService = AppRetrofit().filmeService) {
    private val TAG = FilmeWebClient::class.java.simpleName

    private fun <T> executaRequisicao(
        call: Call<T>,
        quandoSucesso: (filmesNovos: T?) -> Unit,
        quandoFalha: (erro: String?) -> Unit) {
        call.enqueue(object : Callback<T>{
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    quandoSucesso(response.body())
                } else {
                    quandoFalha(REQUISICAO_NAO_SUCEDIDA)
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                quandoFalha(t.message)
            }

        })
    }

    fun buscaTodas(
        quandoSucesso: (filmesNovos: Filme?) -> Unit,
        quandoFalha: (erro: String?) -> Unit) {
        executaRequisicao(
            service.filmes(
                API_TOKEN,
                IDIOMA,
                ORDENAR_DESCRECENTE,
                FILMES_ADULTOS,
                FILMES_COM_VIDEO,
                PAGINA), quandoSucesso, quandoFalha)
    }

}