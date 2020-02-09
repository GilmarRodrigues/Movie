package com.br.teste.cubosfilme.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.extensions.loadUrl
import com.br.teste.cubosfilme.model.Resultado
import com.br.teste.cubosfilme.utils.FILME_RESULTADO_KEY
import com.br.teste.cubosfilme.utils.URL_BASE_IMG
import kotlinx.android.synthetic.main.activity_filme.*

class FilmeActivity : AppCompatActivity() {
    private val mResultado by lazy { intent.getParcelableExtra(FILME_RESULTADO_KEY) as Resultado }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filme)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        populaView(mResultado)
    }

    private fun populaView(resultado: Resultado) {
        resultado?.apply {
            populaToolbar(resultado)
            populaFoto(resultado)
            populaConteudo(resultado)
        }
    }

    private fun populaToolbar(resultado: Resultado) {
        supportActionBar?.title = resultado.title
    }

    private fun populaFoto(resultado: Resultado) {
        iv_foto_filme_activity.loadUrl(URL_BASE_IMG + resultado.poster_path)
    }

    private fun populaConteudo(resultado: Resultado) {
        tv_conteudo_filme_activity.text = resultado.overview
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
