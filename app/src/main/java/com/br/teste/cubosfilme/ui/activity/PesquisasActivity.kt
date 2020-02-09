package com.br.teste.cubosfilme.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.DefaultItemAnimator
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.model.Filme
import com.br.teste.cubosfilme.ui.adapter.FilmesAdapter
import com.br.teste.cubosfilme.utils.FILME_PESQUISA_KEY
import com.br.teste.cubosfilme.utils.FILME_RESULTADO_KEY
import kotlinx.android.synthetic.main.activity_pesquisas.*
import org.jetbrains.anko.startActivity

class PesquisasActivity : AppCompatActivity() {

    private val mFilmePesquisa by lazy { intent.getParcelableExtra(FILME_PESQUISA_KEY) as Filme }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisas)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraRecycleView()
    }

    private fun configuraRecycleView() {
        recycleview_pesquisas.itemAnimator = DefaultItemAnimator()
        recycleview_pesquisas.setHasFixedSize(true)
        val adapter = configuraAdapter(mFilmePesquisa)
        recycleview_pesquisas.adapter = adapter
    }

    fun configuraAdapter(filme: Filme): FilmesAdapter {
        val adapter = FilmesAdapter(filme.results) { resultado ->
            startActivity<FilmeActivity>(FILME_RESULTADO_KEY to resultado)
        }
        return adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
