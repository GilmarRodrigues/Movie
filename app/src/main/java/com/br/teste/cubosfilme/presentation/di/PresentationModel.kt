package com.br.teste.cubosfilme.presentation.di

import com.br.teste.cubosfilme.presentation.details.MovieDetailsViewModel
import com.br.teste.cubosfilme.presentation.list.MovieViewModel
import com.br.teste.cubosfilme.presentation.list.adapter.MovieListAdapter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel<MovieViewModel> {
        MovieViewModel(
            getMovieListUserCase = get()
        )
    }
    viewModel<MovieDetailsViewModel> { (id: Long) ->
        MovieDetailsViewModel(
            id = id,
            repository = get()
        )
    }
    factory<MovieListAdapter> {
        MovieListAdapter(
            context = get()
        )
    }
}