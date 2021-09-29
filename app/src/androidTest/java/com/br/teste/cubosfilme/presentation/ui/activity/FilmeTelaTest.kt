package com.br.teste.cubosfilme.presentation.ui.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.presentation.MainActivity
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

private const val TEMPO_MILISEGUNDOS: Long = 3000

class FilmeTelaTest {

//    @get:Rule
//    val activity = ActivityTestRule(MainActivity::class.java, true, true)
//
//    @Before
//    fun setup() {
//        // delay para carregar a api
//        Thread.sleep(TEMPO_MILISEGUNDOS)
//    }
//
//    @Test
//    fun deve_AparecerADescricaoDoFilme_QuandoClicarEmUmFilme() {
//
//        onView(
//            allOf(
//                withId(R.id.tv_titulo_adapter_filmes),
//                withText("1917"),
//                isDisplayed()
//            )
//        )
//            .perform(click())
//
//        onView(
//            allOf(
//                withText("Os cabos Schofield e Blake são jovens soldados britânicos durante a Primeira Guerra Mundial. Quando eles são encarregados de uma missão aparentemente impossível, os dois precisam atravessar território inimigo, lutando contra o tempo, para entregar uma mensagem que pode salvar seus colegas de batalhão."),
//                withId(R.id.tv_conteudo_filme_activity),
//                isDisplayed()
//            )
//        )
//            .check(matches(withText("Os cabos Schofield e Blake são jovens soldados britânicos durante a Primeira Guerra Mundial. Quando eles são encarregados de uma missão aparentemente impossível, os dois precisam atravessar território inimigo, lutando contra o tempo, para entregar uma mensagem que pode salvar seus colegas de batalhão.")))
//    }
//
//    @Test
//    fun deve_AparecerADescricaoDoQuintoFilme_QuandoClicarEmUmFilme() {
//        onView(
//            allOf(
//                withId(R.id.recycleview_filmes),
//                isDisplayed()
//            )
//        )
//            .perform(scrollToPosition<RecyclerView.ViewHolder>(4))
//            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(4, click()))
//
//        onView(
//            allOf(
//                withId(R.id.tv_conteudo_filme_activity),
//                isDisplayed()
//            )
//        )
//            .check(matches(withText("Durante a década de 1960, a Ford resolve entrar no ramo das corridas automobilísticas de forma que a empresa ganhe o prestígio e o glamour da concorrente Ferrari, campeoníssima em várias corridas. Para tanto, contrata o ex-piloto Carroll Shelby (Matt Damon) para chefiar a empreitada. Por mais que tenha carta branca para montar sua equipe, incluindo o piloto e engenheiro Ken Miles (Christian Bale), Shelby enfrenta problemas com a diretoria da Ford, especialmente pela mentalidade mais voltada para os negócios e a imagem da empresa do que propriamente em relação ao aspecto esportivo.")))
//    }

}
