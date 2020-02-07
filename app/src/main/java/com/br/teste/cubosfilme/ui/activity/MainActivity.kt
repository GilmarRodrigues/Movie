package com.br.teste.cubosfilme.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.model.Filme
import com.br.teste.cubosfilme.rest.FilmeRest
import com.br.teste.cubosfilme.ui.adapter.TabsAdapter
import com.br.teste.cubosfilme.utils.API_TOKEN
import com.br.teste.cubosfilme.utils.FILME_PESQUISA_KEY
import com.br.teste.cubosfilme.utils.IDIOMA
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_filmes.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        configuraTabs()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        configuraPesquisa(menu)
        return true

    }

    private fun configuraPesquisa(menu: Menu?) {
        val searchItem = menu?.findItem(R.id.menu_pesquisar)
        val searchView = searchItem?.actionView as SearchView
        searchView.queryHint = getString(R.string.text_menu_pesquisar)
        searchView.setOnQueryTextListener(pesquisar())
    }

    private fun pesquisar(): SearchView.OnQueryTextListener? {
        return object :SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                pesquisaFilmesTask(query) { filme ->
                    startActivity<PesquisasActivity>(FILME_PESQUISA_KEY to filme)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        }
    }

    private fun pesquisaFilmesTask(titulo: String?, success: (Filme) -> Unit) {
        titulo?.let {
            FilmeRest.filmesPorTitulo(this, API_TOKEN, IDIOMA, it, { filme ->
                success(filme)
                progress.visibility = View.GONE
            }, {
                toast(getString(R.string.erro_tente_mais_tarde))
            })
        }
    }

    private fun configuraTabs() {
        val tabsAdapter = TabsAdapter(this, supportFragmentManager)
        view_pager.adapter = tabsAdapter
        tabs.setupWithViewPager(view_pager)
    }

}
