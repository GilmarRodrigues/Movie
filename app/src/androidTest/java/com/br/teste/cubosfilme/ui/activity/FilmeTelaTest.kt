package com.br.teste.cubosfilme.ui.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.br.teste.cubosfilme.R
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FilmeTelaTest {

    @get:Rule
    val activity = ActivityTestRule(MainActivity::class.java, true, true)

    @Before
    fun setup() {
        // delay para carregar a api
        Thread.sleep(2000)
    }

    @Test
    fun deve_ApareceADescricaoDoFilme_QuandoClicarEmUmFilme() {

        onView(allOf(
            withId(R.id.tv_titulo_adapter_filmes),
            withText("1917"),
            isDisplayed()))
            .perform(click())

        onView(allOf(
            withText("Os cabos Schofield e Blake são jovens soldados britânicos durante a Primeira Guerra Mundial. Quando eles são encarregados de uma missão aparentemente impossível, os dois precisam atravessar território inimigo, lutando contra o tempo, para entregar uma mensagem que pode salvar seus colegas de batalhão."),
            withId(R.id.tv_conteudo_filme_activity),
            isDisplayed()))
            .check(matches(withText("Os cabos Schofield e Blake são jovens soldados britânicos durante a Primeira Guerra Mundial. Quando eles são encarregados de uma missão aparentemente impossível, os dois precisam atravessar território inimigo, lutando contra o tempo, para entregar uma mensagem que pode salvar seus colegas de batalhão.")))
    }

}
