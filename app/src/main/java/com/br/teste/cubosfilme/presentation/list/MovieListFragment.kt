package com.br.teste.cubosfilme.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.br.teste.cubosfilme.databinding.FragmentListaFilmesBinding
import com.br.teste.cubosfilme.presentation.extensions.mostraErro
import com.br.teste.cubosfilme.presentation.list.adapter.MovieAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


private const val MENSAGEM_FALHA_CARREGAR_NOTICIAS = "Não foi possível carregar os novos filmes"
private const val TITULO_APPBAR = "Filmes"

class ListaFilmesFragment : Fragment() {
    private val adapter: MovieAdapter by inject()
    private val viewModel: MovieListViewModel by viewModel()
    private val controlador by lazy { findNavController() }

    private var _binding:FragmentListaFilmesBinding? = null
    private val binding by lazy { _binding!! }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buscaFilmes()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaFilmesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecycleView()
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        activity?.title = TITULO_APPBAR
    }

    private fun configuraRecycleView() {
        binding.fragmentRecycleviewFilmes.itemAnimator = DefaultItemAnimator()
        binding.fragmentRecycleviewFilmes.setHasFixedSize(true)
        binding.fragmentRecycleviewFilmes.adapter = adapter
        configuraAdapter()

    }

    private fun configuraAdapter() {
        adapter.quandoItemClicado = { resultadoSelecionado ->
            vaiParaVisualizaFilme(resultadoSelecionado.id)
        }
    }

    private fun vaiParaVisualizaFilme(resultadoId: Long) {
        val direcao =
            ListaFilmesFragmentDirections.acaoListaFilmesFragmentParaVisualizaFilmeFragment(
                resultadoId
            )
        controlador.navigate(direcao)
    }

    private fun buscaFilmes() {
        viewModel.buscaTodos().observe(this) { resource ->
            resource.dado?.let { adapter.atualiza(it) }
            resource.erro?.let { mostraErro(MENSAGEM_FALHA_CARREGAR_NOTICIAS) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}