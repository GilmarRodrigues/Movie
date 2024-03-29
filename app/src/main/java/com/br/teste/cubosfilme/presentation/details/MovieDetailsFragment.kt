package com.br.teste.cubosfilme.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.br.teste.cubosfilme.databinding.FragmentVisualizaFilmeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MovieDetailsFragment : Fragment() {
    private val argumentos by navArgs<MovieDetailsFragmentArgs>()
    private val resultadoId by lazy { argumentos.resultadoId }
    private val detailsViewModel: MovieDetailsViewModel by viewModel { parametersOf(resultadoId) }
    private val controlador by lazy { findNavController() }

    private var _binding: FragmentVisualizaFilmeBinding? = null
    private val binding by lazy { _binding!! }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        buscaResultadoSelecionado()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVisualizaFilmeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun buscaResultadoSelecionado() {

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) vaiParaListaFilmes()
        return super.onOptionsItemSelected(item)
    }

    private fun vaiParaListaFilmes() {
        controlador.popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}