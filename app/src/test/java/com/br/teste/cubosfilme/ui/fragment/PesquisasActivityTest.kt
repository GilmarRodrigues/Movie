package com.br.teste.cubosfilme.ui.fragment

import com.br.teste.cubosfilme.model.Filme
import com.br.teste.cubosfilme.rest.FilmeRestTest
import com.br.teste.cubosfilme.ui.activity.PesquisasActivity
import com.br.teste.cubosfilme.utils.API_TOKEN
import com.br.teste.cubosfilme.utils.IDIOMA
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test

private const val TITULO_FILME = "Capitão Marvel"
private const val TEMPO_MILISEGUNDOS: Long = 5000
private const val ERRO_AO_BUSCAR_DADOS_NA_API = "Erro ao buscar dados na api"

class PesquisasActivityTest {
    private lateinit var mFilme: Filme

    @Before
    fun setup() {
        carregaFilmes(TITULO_FILME)
        // delay para carregar os filmes da api
        Thread.sleep(TEMPO_MILISEGUNDOS)
    }

    @Test
    fun deve_CarregarListaDeFilme_QuandoBuscarFilmesNaApiPorTitulo() {
        if (mFilme == null) {
            fail(ERRO_AO_BUSCAR_DADOS_NA_API)
        }

        val adapter = PesquisasActivity().configuraAdapter(mFilme)
        val quantidadeFilmes = mFilme.results.size

        assertThat(quantidadeFilmes, Is.`is`(adapter.itemCount))

    }

    private fun carregaFilmes(titulo: String) {
        FilmeRestTest.filmesPorTitulo(API_TOKEN, IDIOMA, titulo, { filme ->
            mFilme = filme
        },{})
    }
}