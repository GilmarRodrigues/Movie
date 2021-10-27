package com.br.teste.cubosfilme.domain.mappers

import com.br.teste.cubosfilme.data.api.response.MovieDto
import com.br.teste.cubosfilme.domain.entity.MovieDomain

fun List<MovieDto>.toDomain(): List<MovieDomain> = this.map { it.toDomain() }

fun MovieDto.toDomain() = MovieDomain(
    id = id,
    popularity = popularity,
    voteCount = voteCount,
    video = video,
    posterPath = posterPath,
    adult = adult,
    backdropPath = backdropPath,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    title = title,
    voteAverage = voteAverage,
    overview = overview,
    releaseDate = releaseDate
)