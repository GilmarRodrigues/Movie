package com.br.teste.cubosfilme.presentation.list.viewstate

import com.br.teste.cubosfilme.presentation.dataui.MovieDataUi

sealed class GetMoviesViewState {
    data class Loading(val loading: Boolean = false) : GetMoviesViewState()
    data class Content(val movies: List<MovieDataUi> = mutableListOf()) : GetMoviesViewState()
    data class Error(val exception: String?) : GetMoviesViewState()
}
