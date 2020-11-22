package com.br.teste.cubosfilme.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.model.Resultado
import com.br.teste.cubosfilme.ui.activity.extensions.loadUrl
import com.br.teste.cubosfilme.ui.viewmodel.VisualizaFilmeViewModel
import com.br.teste.cubosfilme.utils.RESUTADO_ID_CHAVE
import com.br.teste.cubosfilme.utils.URL_BASE_IMG
import kotlinx.android.synthetic.main.fragment_visualiza_filme.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class VisualizaFilmeFragment: Fragment() {
    private val resultadoId by lazy { arguments?.getLong(RESUTADO_ID_CHAVE) ?: IllegalArgumentException("Id inválido")}
    private val viewModel: VisualizaFilmeViewModel by viewModel { parametersOf(resultadoId)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        buscaResultadoSelecionado()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_visualiza_filme, container, false)
    }

    private fun buscaResultadoSelecionado() {
        viewModel.filmeEncontrado.observe(this, Observer {   resultadoEncontardo ->
            resultadoEncontardo?.let {
                preencheCampos(it)
                preencheToolbar(it)
            }
        })
    }

    private fun preencheToolbar(resultado: Resultado) {
        activity?.title = resultado.title
    }

    private fun preencheCampos(resultado: Resultado) {
        iv_foto_filme_fragment.loadUrl(URL_BASE_IMG + resultado.poster_path)
        tv_conteudo_filme_fragment.text = resultado.overview
    }


}