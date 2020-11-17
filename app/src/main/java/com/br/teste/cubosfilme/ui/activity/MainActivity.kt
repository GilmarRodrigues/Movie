package com.br.teste.cubosfilme.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.ui.extensions.mostraErro
import com.br.teste.cubosfilme.model.Resultado
import com.br.teste.cubosfilme.repository.AppDatabase
import com.br.teste.cubosfilme.repository.ResultadoRepository
import com.br.teste.cubosfilme.ui.adapter.FilmesAdapter
import com.br.teste.cubosfilme.ui.viewmodel.ListaFilmesViewModel
import com.br.teste.cubosfilme.ui.viewmodel.factory.ListaFilmesViewModelFactory
import com.br.teste.cubosfilme.utils.RESUTADO_ID_CHAVE
import kotlinx.android.synthetic.main.activity_main.*

private const val MENSAGEM_FALHA_CARREGAR_NOTICIAS = "Não foi possível carregar os novos filmes"

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { FilmesAdapter(this) }
    private val viewModel by lazy {
        val repository = ResultadoRepository(AppDatabase.getInstance(this).resultadoDAO)
        val factory = ListaFilmesViewModelFactory(repository)
        ViewModelProvider(this, factory).get(ListaFilmesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configuraRecycleView()
    }

    override fun onResume() {
        super.onResume()
        buscaFilmes()
    }

    private fun configuraRecycleView() {
        recycleview_filmes.itemAnimator = DefaultItemAnimator()
        recycleview_filmes.setHasFixedSize(true)
        recycleview_filmes.adapter = adapter
        configuraAdapter()
    }

    fun configuraAdapter() {
        adapter.quandoItemClicado = this::abreVizualizadorFilme
    }

    private fun abreVizualizadorFilme(resultado: Resultado) {
        val intent = Intent(this, VizualizaFilmeActivity::class.java)
        intent.putExtra(RESUTADO_ID_CHAVE, resultado.id)
        startActivity(intent)
    }

    private fun buscaFilmes() {
        viewModel.buscaTodos().observe(this, Observer {resource ->
            resource.dado?.let { adapter.atualiza(it) }
            resource.erro?.let {  mostraErro(MENSAGEM_FALHA_CARREGAR_NOTICIAS) }
        })
    }
}
