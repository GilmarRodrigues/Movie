package com.br.teste.cubosfilme.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.model.Filme
import com.br.teste.cubosfilme.rest.FilmeRest
import com.br.teste.cubosfilme.ui.activity.FilmeActivity
import com.br.teste.cubosfilme.ui.adapter.FilmesAdapter
import com.br.teste.cubosfilme.utils.API_TOKEN
import com.br.teste.cubosfilme.utils.FILME_RESULTADO_KEY
import com.br.teste.cubosfilme.utils.IDIOMA
import kotlinx.android.synthetic.main.fragment_filmes.*
import org.jetbrains.anko.toast
import org.jetbrains.anko.startActivity

private const val GENERO_ACAO_ID = 28
private const val GENERO_DRAMA_ID = 18
private const val GENERO_FANTASIA_ID = 14
private const val GENERO_FICCAO_ID = 878

class FilmesFragment : Fragment() {

    private val generos = arrayOf(GENERO_ACAO_ID, GENERO_DRAMA_ID, GENERO_FANTASIA_ID, GENERO_FICCAO_ID)
    private val index by lazy { (arguments?.getInt(ARG_TAB_SELECIONADO) ?: 1) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_filmes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        carregaLista()
    }

    private fun carregaLista() {
        filmesTask { filme ->
            configuraRecycleView(filme)
        }
    }

    private fun configuraRecycleView(filme: Filme) {
        recycleview_filmes.itemAnimator = DefaultItemAnimator()
        recycleview_filmes.setHasFixedSize(true)
        val adapter = configuraAdapter(filme)
        recycleview_filmes.adapter = adapter
    }

    fun configuraAdapter(filme: Filme): FilmesAdapter {
        val adapter = FilmesAdapter(filme.results) { resultadoFilme ->
            activity?.startActivity<FilmeActivity>(FILME_RESULTADO_KEY to resultadoFilme)
        }
        return adapter
    }

    private fun filmesTask(success: (Filme) -> Unit) {
        context?.let { context ->
            FilmeRest.filmesPorGeneros(context, API_TOKEN, IDIOMA, generos[index-1], { filme ->
                success(filme)
                progress.visibility = View.GONE
            }, {
                context.toast(getString(R.string.erro_tente_mais_tarde))
            })
        }
    }

    companion object {
        private const val ARG_TAB_SELECIONADO = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): FilmesFragment {
            return FilmesFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_TAB_SELECIONADO, sectionNumber)
                }
            }
        }

    }
}