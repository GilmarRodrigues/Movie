package com.br.teste.cubosfilme.data.repository

import com.br.teste.cubosfilme.core.network.Result
import com.br.teste.cubosfilme.data.api.response.MovieListDto
import com.br.teste.cubosfilme.data.database.entity.MovieCache
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(): Flow<Result<MovieListDto?>>
}