package com.br.teste.cubosfilme.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.model.Resultado
import com.br.teste.cubosfilme.ui.extensions.loadUrl
import com.br.teste.cubosfilme.ui.viewmodel.VizualizaFilmeViewModel
import com.br.teste.cubosfilme.utils.RESUTADO_ID_CHAVE
import com.br.teste.cubosfilme.utils.URL_BASE_IMG
import kotlinx.android.synthetic.main.activity_vizualiza_filme.*
import org.koin.android.viewmodel.ext.android.viewModel

class VizualizaFilmeActivity : AppCompatActivity() {
    private val resultadoId by lazy { intent.getLongExtra(RESUTADO_ID_CHAVE, 0) }
    private val viewModel: VizualizaFilmeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vizualiza_filme)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        buscaResultadoSelecionado()
    }

    private fun buscaResultadoSelecionado() {
        viewModel.buscaPorId(resultadoId).observe(this, Observer {   resultadoEncontardo ->
            resultadoEncontardo?.let {
                preencheCampos(it)
                preencheToolbar(it)
            }
        })
    }

    private fun preencheToolbar(resultado: Resultado) {
        title = resultado.title
    }

    private fun preencheCampos(resultado: Resultado) {
        iv_foto_filme_activity.loadUrl(URL_BASE_IMG + resultado.poster_path)
        tv_conteudo_filme_activity.text = resultado.overview
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
