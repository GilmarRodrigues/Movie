package com.br.teste.cubosfilme.presentation.list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.teste.cubosfilme.data.database.Resultado
import com.br.teste.cubosfilme.databinding.AdapterFilmesBinding
import com.br.teste.cubosfilme.presentation.databinding.ResultadoData


class FilmesAdapter(
    private val context: Context,
    private val resultados: MutableList<Resultado> = mutableListOf(),
    var quandoItemClicado: (resultado: Resultado) -> Unit = {}
) : RecyclerView.Adapter<FilmesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val viewDataBinding = AdapterFilmesBinding.inflate(inflater, parent, false)
        return ViewHolder(viewDataBinding)
    }

    override fun getItemCount() = resultados.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resultado = resultados[position]
        holder.vincula(resultado)
    }

    fun atualiza(resultados: List<Resultado>) {
        notifyItemRangeRemoved(0, this.resultados.size)
        this.resultados.clear()
        this.resultados.addAll(resultados)
        notifyItemRangeInserted(0, this.resultados.size)
    }

    inner class ViewHolder(private val viewDataBinding: AdapterFilmesBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root), View.OnClickListener {
        private lateinit var resultado: Resultado

        init {
            viewDataBinding.clicaNoFilme = this
        }

        fun vincula(resultado: Resultado) {
            this.resultado = resultado
            viewDataBinding.resultado = ResultadoData(resultado)
        }

        override fun onClick(view: View?) {
            if (::resultado.isInitialized) {
                quandoItemClicado(resultado)
            }
        }
    }
}
