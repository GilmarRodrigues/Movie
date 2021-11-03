package com.br.teste.cubosfilme.domain.usercase

import com.br.teste.cubosfilme.core.network.Result
import com.br.teste.cubosfilme.data.api.response.MovieListDto
import com.br.teste.cubosfilme.data.repository.MovieRepository
import com.br.teste.cubosfilme.domain.entity.MovieDomain
import com.br.teste.cubosfilme.domain.mappers.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.lang.Exception

class GetMovieListUserCase(
    private val repository: MovieRepository
) {

    operator fun invoke(): Flow<Result<List<MovieDomain>?>> {
        return repository
            .getMovies()
            .map {
                mapResult(it)
            }
    }

    private fun mapResult(result: Result<MovieListDto?>) =
        when (result) {
            is Result.Success<MovieListDto> -> Result.Success(data = result.data?.movies?.toDomain())
            is Result.Error -> Result.Error(exception = result.exception)
        }
}
