package com.br.teste.cubosfilme.ui.adapter

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.ui.fragment.FilmesFragment

private val TAB_TITULOS = arrayOf(R.string.tab_text_acao, R.string.tab_text_drama, R.string.tab_text_fantasia, R.string.tab_text_ficcao)

private const val  QUANTIDADE_TABS = 4

class TabsAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) = FilmesFragment.newInstance(position + 1)

    override fun getPageTitle(position: Int) = context.resources.getString(TAB_TITULOS[position])

    override fun getCount() = QUANTIDADE_TABS
}