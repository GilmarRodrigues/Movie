package com.br.teste.cubosfilme.ui.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.br.teste.cubosfilme.R
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainTelaTest {

    @get:Rule
    val activity = ActivityTestRule(MainActivity::class.java, true, true)

    @Before
    fun setup() {
        // delay para carregar a api
        Thread.sleep(2000)
    }

    @Test
    fun deve_AparecerUmFilme_QuandoCarregarFilmesNaApi() {
        onView(allOf(
            withId(R.id.tv_titulo_adapter_filmes),
            withText("Aves de Rapina: Arlequina e sua Emancipação Fantabulosa"),
            isDisplayed()))
            .check(matches(withText("Aves de Rapina: Arlequina e sua Emancipação Fantabulosa")))
    }

    @Test
    fun deve_AparecerDoisFilme_QuandoCarregarFilmesNaApi() {
        onView(allOf(
            withId(R.id.tv_titulo_adapter_filmes),
            withText("Aves de Rapina: Arlequina e sua Emancipação Fantabulosa"),
            isDisplayed()))
            .check(matches(withText("Aves de Rapina: Arlequina e sua Emancipação Fantabulosa")))

        onView(allOf(
            withId(R.id.tv_titulo_adapter_filmes),
            withText("1917"),
            isDisplayed()))
            .check(matches(withText("1917")))
    }

    @Test
    fun deve_AparecerUmFilme_QuandoClicarNaTab() {
        onView(allOf(
            withContentDescription("Drama"),
            isDisplayed()))
            .perform(ViewActions.click())

        onView(allOf(
            withId(R.id.tv_titulo_adapter_filmes),
            withText("1917"),
            isDisplayed()))
            .check(matches(withText("1917")))
    }

}
