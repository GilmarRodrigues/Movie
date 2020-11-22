package com.br.teste.cubosfilme.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.br.teste.cubosfilme.asynctask.BaseAsyncTask
import com.br.teste.cubosfilme.model.Resultado
import com.br.teste.cubosfilme.repository.dao.ResultadoDAO
import com.br.teste.cubosfilme.retrofit.webclient.FilmeWebClient

class ResultadoRepository(
    private val dao: ResultadoDAO,
    private val webclient: FilmeWebClient) {

    private val mediador = MediatorLiveData<Resource<List<Resultado>?>>()

    fun buscaTodos(): LiveData<Resource<List<Resultado>?>> {

        mediador.addSource(buscaInterna()) {resultadosEncontrados ->
            mediador.value = Resource(dado = resultadosEncontrados)
        }

        val falhasDaWebApiLiveData = MutableLiveData<Resource<List<Resultado>?>>()
        mediador.addSource(falhasDaWebApiLiveData) { resourceDeFalha ->
            val resourceAtual = mediador.value
            val resourceNovo: Resource<List<Resultado>?> = if (resourceAtual != null) {
                Resource(dado = resourceAtual.dado, erro = resourceDeFalha.erro)
            } else {
                resourceDeFalha
            }
            mediador.value = resourceNovo
        }
        buscaNaApi( quandoFalha = {erro ->
            falhasDaWebApiLiveData.value = Resource(dado = null, erro = erro)
        })
        return mediador
    }

    private fun buscaInterna(): LiveData<List<Resultado>> {
        return dao.buscaTodos()
    }

    private fun buscaNaApi(quandoFalha: (erro: String?) -> Unit) {
        webclient.buscaTodas(
        quandoSucesso = {
            it?.let {novosFilmes ->
                salvaInterno(novosFilmes.results)
            }
        }, quandoFalha = quandoFalha)
    }

    private fun salvaInterno(resultados: List<Resultado>) {
        BaseAsyncTask(
            quandoExecuta = {
                dao.salva(resultados)
            }, quandoFinaliza = {}
        ).execute()
    }

    private fun salvaInterno(resultado: Resultado, quandoSucesso: () -> Unit) {
        BaseAsyncTask(
            quandoExecuta = {
                dao.salva(resultado)
            }, quandoFinaliza = {
                quandoSucesso()
            }
        )
    }

    fun buscaPorId(resultadoId: Long): LiveData<Resultado?>{
        return dao.buscaPorId(resultadoId)
    }

}