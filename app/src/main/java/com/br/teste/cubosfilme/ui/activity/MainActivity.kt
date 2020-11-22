package com.br.teste.cubosfilme.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.model.Resultado
import com.br.teste.cubosfilme.ui.activity.extensions.transacaoFragment
import com.br.teste.cubosfilme.ui.fragment.ListaFilmesFragment
import com.br.teste.cubosfilme.ui.fragment.VisualizaFilmeFragment
import com.br.teste.cubosfilme.utils.RESUTADO_ID_CHAVE
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG_FRAGMENT_VISUALIZA_FILME = "visualizaFilme"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configuraFragmentPeloEstado(savedInstanceState)
    }

    private fun configuraFragmentPeloEstado(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            abreListaFilmes()
        } else {
            tentaReabrirFragmentVisualizaFilme()
        }
    }

    private fun tentaReabrirFragmentVisualizaFilme() {
        supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_VISUALIZA_FILME)
            ?.let { fragment ->

                val argumentos = fragment.arguments
                val novoFragment = VisualizaFilmeFragment()
                novoFragment.arguments = argumentos

                removeFragmentVizualizaFilme(fragment)

                transacaoFragment {
                    val conteiner = configuraContainerFragmentVisualizaFilme()
                    replace(conteiner, novoFragment, TAG_FRAGMENT_VISUALIZA_FILME)
                }

            }
    }

    private fun FragmentTransaction.configuraContainerFragmentVisualizaFilme(): Int {
        if (activity_filmes_container_secundario != null) {
            return R.id.activity_filmes_container_secundario
        }
        addToBackStack(null)
        return R.id.activity_filmes_container_primario
    }

    private fun abreListaFilmes() {
        transacaoFragment {
            add(R.id.activity_filmes_container_primario, ListaFilmesFragment())
        }
    }

    private fun abreVizualizadorFilme(resultado: Resultado) {
        val fragment = VisualizaFilmeFragment()
        var dados = Bundle()
        dados.putLong(RESUTADO_ID_CHAVE, resultado.id)
        fragment.arguments = dados

        transacaoFragment {
            val conteiner = configuraContainerFragmentVisualizaFilme()
            replace(conteiner, fragment, TAG_FRAGMENT_VISUALIZA_FILME)
        }
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        when(fragment) {
            is ListaFilmesFragment -> {
                configuraListaFilme(fragment)
            }
        }
    }

    private fun configuraListaFilme(fragment: ListaFilmesFragment) {
        fragment.quandoFilmeSelecionado = this::abreVizualizadorFilme
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)  {
            supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_VISUALIZA_FILME)?.let {fragment ->
                removeFragmentVizualizaFilme(fragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun removeFragmentVizualizaFilme(fragment: Fragment) {
        transacaoFragment {
            remove(fragment)
        }
        supportFragmentManager.popBackStack()
    }
}
