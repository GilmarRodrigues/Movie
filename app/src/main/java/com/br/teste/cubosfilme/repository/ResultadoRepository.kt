package com.br.teste.cubosfilme.repository

import android.util.Log
import com.br.teste.cubosfilme.asynctask.BaseAsyncTask
import com.br.teste.cubosfilme.model.Resultado
import com.br.teste.cubosfilme.repository.dao.ResultadoDAO
import com.br.teste.cubosfilme.retrofit.webclient.FilmeWebClient

class ResultadoRepository(
    private val dao: ResultadoDAO,
    private val webclient: FilmeWebClient = FilmeWebClient()) {

    fun buscaTodos(quandoSucesso: (List<Resultado>) -> Unit, quandoFalha: (erro: String?) -> Unit) {
        buscaInterna(quandoSucesso)
        buscaNaApi(quandoSucesso, quandoFalha)
    }

    private fun buscaInterna(quandoSucesso: (List<Resultado>) -> Unit) {
        BaseAsyncTask(quandoExecuta = {
            dao.buscaTodos()
        }, quandoFinaliza = quandoSucesso)
            .execute()
    }

    private fun buscaNaApi(quandoSucesso: (List<Resultado>) -> Unit, quandoFalha: (erro: String?) -> Unit) {
        webclient.buscaTodas(
        quandoSucesso = {
            it?.let {novosFilmes ->
                salvaInterno(novosFilmes.results, quandoSucesso)
            }
        }, quandoFalha = quandoFalha)
    }

    private fun salvaInterno(resultados: List<Resultado>, quandoSucesso: (List<Resultado>) -> Unit) {
        BaseAsyncTask(
            quandoExecuta = {
                dao.salva(resultados)
                dao.buscaTodos()
            }, quandoFinaliza = quandoSucesso
        ).execute()
    }

    private fun salvaInterno(resultado: Resultado, quandoSucesso: (resultado: Resultado) -> Unit) {
        BaseAsyncTask(
            quandoExecuta = {
                dao.salva(resultado)
                dao.buscaPorId(resultado.id)
            }, quandoFinaliza = {resultadoEncontardo ->
                resultadoEncontardo?.let {
                    quandoSucesso(it)
                }

            }
        )
    }

    fun buscaPorId(resultadoId: Long, quandoSucesso: (resultado: Resultado?) -> Unit) {
        BaseAsyncTask(quandoExecuta = {
            dao.buscaPorId(resultadoId)
        }, quandoFinaliza = quandoSucesso).execute()
    }

}