package com.br.teste.cubosfilme.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.model.Filme
import com.br.teste.cubosfilme.rest.FilmeRest
import com.br.teste.cubosfilme.ui.adapter.FilmesAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.toast

private const val API_TOKEN = "6c05f9965be289e35bb428a2bd4604a9"
private const val IDIOMA = "pt-BR"

class FilmesFragment : Fragment() {

    private val generos = arrayOf(28, 18, 14, 878)
    private val index by lazy { (arguments?.getInt(ARG_TAB_SELECIONADO) ?: 1) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configuracao()
    }

    private fun configuracao() {
        configuraRecycleView()
    }

    private fun configuraRecycleView() {
        filmesTask {filme ->
            recycleview_filmes.itemAnimator = DefaultItemAnimator()
            recycleview_filmes.setHasFixedSize(true)
            val adapter = FilmesAdapter(filme.results) { resultado ->
                //activity?.startActivity<PrayerCategoryActivity>(CATEGORY to category)
                context?.toast(resultado.title)
            }
            recycleview_filmes.adapter = adapter
        }
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