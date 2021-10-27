package com.br.teste.cubosfilme.data.api.dataset

import com.br.teste.cubosfilme.core.network.Result
import com.br.teste.cubosfilme.data.api.response.MovieListDto
import com.br.teste.cubosfilme.data.api.service.MovieService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MovieEventDataSetImpl(
    private val service: MovieService
) : MovieEventDataSet {

    override fun getMovies(): Flow<Result<MovieListDto?>> = flow {
        val response = service.movies()
        if (response.isSuccessful) {
            emit(Result.Success(data = response.body()))
        } else {
            emit(Result.Error(exception = Exception("Erro na busca")))
        }
    }.catch {
        emit(Result.Error(exception = Exception("Erro na internt")))
    }


}