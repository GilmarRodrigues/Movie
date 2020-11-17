package com.br.teste.cubosfilme.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.ui.extensions.loadUrl
import com.br.teste.cubosfilme.model.Resultado
import com.br.teste.cubosfilme.utils.URL_BASE_IMG
import kotlinx.android.synthetic.main.adapter_filmes.view.*


class FilmesAdapter(
    private val context: Context,
    private val resultados: MutableList<Resultado> = mutableListOf(),
    var quandoItemClicado: (resultado: Resultado) -> Unit = {}
) : RecyclerView.Adapter<FilmesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_filmes, parent, false)
        return ViewHolder(view)
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

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view)  {
        private lateinit var resultado: Resultado

        init {
            itemView.setOnClickListener {
                if (::resultado.isInitialized) {
                    quandoItemClicado(resultado)
                }
            }
        }

        fun vincula(resultado: Resultado) {
            this.resultado = resultado
            populaFoto(resultado)
            populaTitullo(resultado)
        }

        private fun populaFoto(resultado: Resultado) {
            itemView.iv_foto_adpter_filmes.loadUrl(URL_BASE_IMG + resultado.poster_path)
        }

        private fun populaTitullo(resultado: Resultado) {
            itemView.tv_titulo_adapter_filmes.text = resultado.title
        }
    }


}
