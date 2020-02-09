package com.br.teste.cubosfilme.ui.fragment

import android.content.Context
import android.util.Log
import com.br.teste.cubosfilme.model.Filme
import com.br.teste.cubosfilme.model.Resultado
import com.br.teste.cubosfilme.rest.FilmeAPI
import com.br.teste.cubosfilme.rest.FilmeClient
import com.br.teste.cubosfilme.rest.FilmeRest
import com.br.teste.cubosfilme.ui.adapter.FilmesAdapter
import com.br.teste.cubosfilme.utils.API_TOKEN
import com.br.teste.cubosfilme.utils.IDIOMA
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FilmesFragmentTest {


    @Mock
    private lateinit var adapter: FilmesAdapter
    private val fragment = FilmesFragment()
    private var quantidadeFilmes: Int = 0

    @Before
    fun setup() {
        val consultorApi = FilmeClient.createClientV1(FilmeAPI::class.java).filmesPorGenero(API_TOKEN, IDIOMA, 28)
        doAsync {
            val response = consultorApi.execute()
            val filme = response.body()
            quantidadeFilmes = filme?.results?.size ?: 0

        }
        fragment.filmesTask {filme ->
            quantidadeFilmes = filme?.results?.size ?: 0
        }
        Thread.sleep(5000)
    }

    @Test
    fun deve_AtualizarListaDeFilme_QuandoBuscarFilmesNaApi() {



        assertThat(quantidadeFilmes, `is`(2))








//        fragment.configuraRecycleView(getFilme())

        /*val quantidadeFilmesDevolvido = adapter.itemCount


        Mockito.doAnswer {
            //val callback = it.arguments[0] as FilmeRest
            val argument = it.arguments[0] as FilmeRest
            argument
            null
        }*/

       // assertThat(quantidadeFilmesDevolvido, `is`(1))

    }

    /*private fun getFilme(): Filme {
        val mutableListOf = mutableListOf<Resultado>()
        mutableListOf.add(getResultado())
        return Filme(10, 1, 1, mutableListOf)
    }

    private fun getResultado() = Resultado(1, 1.1, 1, false, "", false, "",
            "", "",  mutableListOf(), "", 1.1, "", "")*/
}