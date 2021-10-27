package com.br.teste.cubosfilme.data.repository

import com.br.teste.cubosfilme.core.network.Result
import com.br.teste.cubosfilme.data.api.dataset.MovieEventDataSet
import com.br.teste.cubosfilme.data.api.response.MovieListDto
import com.br.teste.cubosfilme.data.database.dao.MovieDao
import com.br.teste.cubosfilme.data.database.entity.MovieCache
import com.br.teste.cubosfilme.data.mapper.toDataCache
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class MovieRepositoryImpl(
    private val movieEventDataSet: MovieEventDataSet
) : MovieRepository {

    override fun getMovies(): Flow<Result<MovieListDto?>> =
        movieEventDataSet.getMovies()
}
