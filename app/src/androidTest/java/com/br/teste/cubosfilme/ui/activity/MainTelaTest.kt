package com.br.teste.cubosfilme.ui.activity

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.ui.adapter.FilmesAdapter
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
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
    fun deve_AparecerOSextoFilme_QuandoCarregarAApiEFazeroScroll() {
        onView(allOf(
            withId(R.id.recycleview_filmes),
            isDisplayed()))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))

        onView(allOf(
            withId(R.id.tv_titulo_adapter_filmes),
            withText("As Aventuras do Dr. Dolittle"),
            isDisplayed()))
            .check(matches(withText("As Aventuras do Dr. Dolittle")))
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
