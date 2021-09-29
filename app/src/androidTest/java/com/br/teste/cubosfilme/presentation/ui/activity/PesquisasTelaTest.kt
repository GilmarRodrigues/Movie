package com.br.teste.cubosfilme.presentation.ui.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.presentation.MainActivity
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test

private const val TEMPO_MILISEGUNDOS: Long = 3000

class PesquisasTelaTest {

//    @get:Rule
//    val activity = ActivityTestRule(MainActivity::class.java, true, true)
//
//
//    @Test
//    fun deve_ApareceUmFilme_QuandoOuverUmaPesquisa() {
//        onView(allOf(
//            withId(R.id.menu_pesquisar), withContentDescription("Pesquisar"),
//            isDescendantOfA(withId(R.id.toolbar)),
//            isDisplayed()))
//            .perform(click())
//
//        onView(allOf(
//            withId(R.id.search_src_text), withHint("Pesquisar"),
//            isDisplayed()))
//            .perform(replaceText("batman"), closeSoftKeyboard())
//
//        onView(allOf(
//            withId(R.id.search_src_text), withText("batman"),
//            isDisplayed()))
//            .perform(pressImeActionButton())
//
//        // delay para carregar a api
//        Thread.sleep(TEMPO_MILISEGUNDOS)
//
//        onView(allOf(
//            withId(R.id.tv_titulo_adapter_filmes), withText("Batman Begins"),
//            isDisplayed()))
//            .check(matches(withText("Batman Begins")))
//    }
}
