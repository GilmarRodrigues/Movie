package com.br.teste.cubosfilme.data.api.dataset

import com.br.teste.cubosfilme.core.network.Result
import com.br.teste.cubosfilme.data.api.response.MovieListDto
import kotlinx.coroutines.flow.Flow

interface MovieEventDataSet {
    fun getMovies(): Flow<Result<MovieListDto?>>
}