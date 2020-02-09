package com.br.teste.cubosfilme.ui.fragment

import android.content.Context
import android.util.Log
import com.br.teste.cubosfilme.model.Filme
import com.br.teste.cubosfilme.model.Resultado
import com.br.teste.cubosfilme.rest.FilmeRest
import com.br.teste.cubosfilme.ui.adapter.FilmesAdapter
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

//@RunWith(MockitoJUnitRunner::class)
class FilmesFragmentTest {


    /*@Mock
    private lateinit var adapter: FilmesAdapter

    @Test
    fun deve_AtualizarListaDeFilme_QuandoBuscarFilmesNaApi() {
        val fragment = FilmesFragment()
        fragment.configuraRecycleView(getFilme())
        *//*Thread.sleep(2000)
        fragment.filmesTask{
            assertThat(5, `is`(1))
        }*//*
        val quantidadeFilmesDevolvido = adapter.itemCount


        Mockito.doAnswer {
            //val callback = it.arguments[0] as FilmeRest
            val argument = it.arguments[0] as FilmeRest
            argument
            null
        }

        assertThat(quantidadeFilmesDevolvido, `is`(1))

    }

    private fun getFilme(): Filme {
        val mutableListOf = mutableListOf<Resultado>()
        mutableListOf.add(getResultado())
        return Filme(10, 1, 1, mutableListOf)
    }

    private fun getResultado() = Resultado(1, 1.1, 1, false, "", false, "",
            "", "",  mutableListOf(), "", 1.1, "", "")*/
}