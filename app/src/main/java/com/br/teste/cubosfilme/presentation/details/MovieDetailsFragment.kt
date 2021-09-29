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
import com.br.teste.cubosfilme.data.database.Resultado
import com.br.teste.cubosfilme.databinding.FragmentVisualizaFilmeBinding
import com.br.teste.cubosfilme.presentation.databinding.ResultadoData
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MovieDetailsFragment : Fragment() {
    private val argumentos by navArgs<MovieDetailsFragmentArgs>()
    private val resultadoId by lazy { argumentos.resultadoId }
    private val viewModel: MovieViewModel by viewModel { parametersOf(resultadoId) }
    private val controlador by lazy { findNavController() }
    private val resultadoData: ResultadoData by lazy { ResultadoData() }

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
        viewModel.filmeEncontrado.observe(this) {
            it?.let { resultadoEncontardo ->
                resultadoData.atualiza(resultadoEncontardo)
                preencheToolbar(resultadoEncontardo)
            }
        }
    }

    private fun preencheToolbar(resultado: Resultado) {
        activity?.title = resultado.title
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