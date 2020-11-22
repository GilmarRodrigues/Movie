package com.br.teste.cubosfilme.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.model.Resultado
import com.br.teste.cubosfilme.ui.adapter.FilmesAdapter
import com.br.teste.cubosfilme.ui.fragment.extensions.mostraErro
import com.br.teste.cubosfilme.ui.viewmodel.ListaFilmesViewModel
import kotlinx.android.synthetic.main.fragment_lista_filmes.*
import org.koin.android.viewmodel.ext.android.viewModel


private const val MENSAGEM_FALHA_CARREGAR_NOTICIAS = "Não foi possível carregar os novos filmes"
private const val TITULO_APPBAR = "Filmes"

class ListaFilmesFragment : Fragment() {
    private val adapter by lazy {
        context?.let {
            FilmesAdapter(context = it)
        } ?: throw IllegalArgumentException("Contexto inválido")
    }

    private val viewModel: ListaFilmesViewModel by viewModel()
    var quandoFilmeSelecionado: (resultado: Resultado) -> Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buscaFilmes()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lista_filmes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecycleView()
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        activity?.title = TITULO_APPBAR
    }

    private fun configuraRecycleView() {
        fragment_recycleview_filmes.itemAnimator = DefaultItemAnimator()
        fragment_recycleview_filmes.setHasFixedSize(true)
        fragment_recycleview_filmes.adapter = adapter
        configuraAdapter()
    }

    fun configuraAdapter() {
        adapter.quandoItemClicado = quandoFilmeSelecionado
    }

    private fun buscaFilmes() {
        viewModel.buscaTodos().observe(this, Observer {resource ->
            resource.dado?.let { adapter.atualiza(it) }
            resource.erro?.let {  mostraErro(MENSAGEM_FALHA_CARREGAR_NOTICIAS) }
        })
    }
}