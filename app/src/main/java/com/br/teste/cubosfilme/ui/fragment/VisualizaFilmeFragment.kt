package com.br.teste.cubosfilme.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.br.teste.cubosfilme.databinding.FragmentVisualizaFilmeBinding
import com.br.teste.cubosfilme.model.Resultado
import com.br.teste.cubosfilme.ui.databinding.ResultadoData
import com.br.teste.cubosfilme.ui.viewmodel.VisualizaFilmeViewModel
import com.br.teste.cubosfilme.utils.URL_BASE_IMG
import kotlinx.android.synthetic.main.fragment_visualiza_filme.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class VisualizaFilmeFragment: Fragment() {
    private val argumentos by navArgs<VisualizaFilmeFragmentArgs>()
    private val resultadoId by lazy { argumentos.resultadoId}
    private val viewModel: VisualizaFilmeViewModel by viewModel { parametersOf(resultadoId)}
    private val controlador by lazy { findNavController() }
    private lateinit var viewDataBinding : FragmentVisualizaFilmeBinding
    private val resultadoData: ResultadoData by lazy { ResultadoData() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        buscaResultadoSelecionado()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentVisualizaFilmeBinding.inflate(inflater, container, false)
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.resultado = resultadoData
        return viewDataBinding.root
    }

    private fun buscaResultadoSelecionado() {
        viewModel.filmeEncontrado.observe(this, Observer {
            it?.let { resultadoEncontardo ->
                resultadoData.atualiza(resultadoEncontardo)
                preencheToolbar(resultadoEncontardo)
            }
        })
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

}