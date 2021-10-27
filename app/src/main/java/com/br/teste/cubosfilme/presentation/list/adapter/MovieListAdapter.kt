package com.br.teste.cubosfilme.presentation.list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.teste.cubosfilme.databinding.AdapterFilmesBinding
import com.br.teste.cubosfilme.presentation.dataui.MovieDataUi


class MovieListAdapter(
    private val context: Context,
    private val movieEntities: MutableList<MovieDataUi> = mutableListOf(),
    var quandoItemClicado: (result: MovieDataUi) -> Unit = {}
) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val viewDataBinding = AdapterFilmesBinding.inflate(inflater, parent, false)
        return ViewHolder(viewDataBinding)
    }

    override fun getItemCount() = movieEntities.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resultado = movieEntities[position]
        holder.vincula(resultado)
    }

    fun update(movies: List<MovieDataUi>) {
        notifyItemRangeRemoved(0, this.movieEntities.size)
        this.movieEntities.clear()
        this.movieEntities.addAll(movies)
        notifyItemRangeInserted(0, this.movieEntities.size)
    }

    inner class ViewHolder(viewDataBinding: AdapterFilmesBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root), View.OnClickListener {
        private lateinit var result: MovieDataUi


        fun vincula(dataUi: MovieDataUi) {
            this.result = dataUi
        }

        override fun onClick(view: View?) {
            if (::result.isInitialized) {
                quandoItemClicado(result)
            }
        }
    }
}
