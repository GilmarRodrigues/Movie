package com.br.teste.cubosfilme.presentation.mapper

import com.br.teste.cubosfilme.domain.entity.MovieDomain
import com.br.teste.cubosfilme.presentation.dataui.MovieDataUi

fun List<MovieDomain>.toPresentation(): List<MovieDataUi> = this.map { it.toPresentation() }

fun MovieDomain.toPresentation() = MovieDataUi(
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