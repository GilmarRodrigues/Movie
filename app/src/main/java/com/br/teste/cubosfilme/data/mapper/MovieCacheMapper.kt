package com.br.teste.cubosfilme.data.mapper

import com.br.teste.cubosfilme.data.api.response.MovieDto
import com.br.teste.cubosfilme.data.database.entity.MovieCache

fun List<MovieDto>.toDataCache(): List<MovieCache> = this.map { it.toDataCache() }

fun MovieDto.toDataCache() = MovieCache(
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