package com.br.teste.cubosfilme.ui.adapter

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.ui.fragment.FilmesFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_acao,
    R.string.tab_text_drama,
    R.string.tab_text_fantasia,
    R.string.tab_text_ficcao
)

class TabsAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) = FilmesFragment.newInstance(position + 1)

    override fun getPageTitle(position: Int) = context.resources.getString(TAB_TITLES[position])

    override fun getCount() = 4
}