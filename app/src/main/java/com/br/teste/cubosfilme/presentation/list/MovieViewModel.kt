package com.br.teste.cubosfilme.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.teste.cubosfilme.core.network.Result
import com.br.teste.cubosfilme.domain.entity.MovieDomain
import com.br.teste.cubosfilme.domain.usercase.GetMovieListUserCase
import com.br.teste.cubosfilme.presentation.list.viewstate.GetMoviesViewState
import com.br.teste.cubosfilme.presentation.mapper.toPresentation
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MovieViewModel(
    private val getMovieListUserCase: GetMovieListUserCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _getMoviewViewState: MutableLiveData<GetMoviesViewState> = MutableLiveData()
    var getMoviesViewState: LiveData<GetMoviesViewState> = _getMoviewViewState

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            getMovieListUserCase()
                .flowOn(dispatcher)
                .onStart { handleLoading(loading = true) }
                .onCompletion { handleLoading(loading = false) }
                .catch {
                    (handleMoviesError(it as Result.Error)) }
                .collect { handleResultMovies(it) }

        }
    }

    private fun handleLoading(loading: Boolean) {
        _getMoviewViewState.value = GetMoviesViewState.Loading(loading = loading)
    }

    private fun handleResultMovies(result: Result<List<MovieDomain>?>) {
        when (result) {
            is Result.Success<List<MovieDomain>> ->
                handleGetMoviesSuccess(result)
            is Result.Error -> handleMoviesError(result)
        }
    }

    private fun handleGetMoviesSuccess(result: Result.Success<List<MovieDomain>>) {
        _getMoviewViewState.value = result.data?.let { movies ->
            GetMoviesViewState.Content(movies = movies.toPresentation())
        }
    }

    private fun handleMoviesError(result: Result.Error) {
        _getMoviewViewState.value =
            GetMoviesViewState.Error(result.exception.message)
    }
}

