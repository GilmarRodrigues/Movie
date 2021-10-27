package com.br.teste.cubosfilme.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.br.teste.cubosfilme.databinding.FragmentListaFilmesBinding
import com.br.teste.cubosfilme.presentation.dataui.MovieDataUi
import com.br.teste.cubosfilme.presentation.list.adapter.MovieListAdapter
import com.br.teste.cubosfilme.presentation.list.viewstate.GetMoviesViewState
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TITULO_APPBAR = "Filmes"

class ListaFilmesFragment : Fragment() {
    private val listAdapter: MovieListAdapter by inject()
    private val viewModel: MovieViewModel by viewModel()
    private val controlador by lazy { findNavController() }

    private var _binding: FragmentListaFilmesBinding? = null
    private val binding by lazy { _binding!! }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObservers()
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
        binding.fragmentRecycleviewFilmes.adapter = listAdapter
        configuraAdapter()

    }

    private fun configuraAdapter() {
        listAdapter.quandoItemClicado = { resultadoSelecionado ->
            //vaiParaVisualizaFilme(resultadoSelecionado.id)
        }
    }

    private fun vaiParaVisualizaFilme(resultadoId: Long) {
        val direcao =
            ListaFilmesFragmentDirections.acaoListaFilmesFragmentParaVisualizaFilmeFragment(
                resultadoId
            )
        controlador.navigate(direcao)
    }

    private fun setupObservers() {
        viewModel.getMoviesViewState.observe(this, ::handleGetMovies)
    }

    private fun handleGetMovies(state: GetMoviesViewState) {
        when (state) {
            is GetMoviesViewState.Loading ->
                Toast.makeText(
                    requireContext(),
                    "Loading ${state.loading}",
                    Toast.LENGTH_SHORT
                ).show()
            is GetMoviesViewState.Content -> {
                setupAdapter(state.movies)
            }
            is GetMoviesViewState.Error ->
                Toast.makeText(
                    requireContext(),
                    state.exception,
                    Toast.LENGTH_SHORT
                ).show()
        }
    }

    private fun setupAdapter(movies: List<MovieDataUi>) {
        listAdapter.update(movies)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}