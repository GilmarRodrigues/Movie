package com.br.teste.cubosfilme.domain.entity

data class MovieDomain(
    val id: Long = 0,
    val popularity: Double,
    val voteCount: Int,
    val video: Boolean = false,
    val posterPath: String?,
    val adult: Boolean = false,
    val backdropPath: String?,
    val originalLanguage: String,
    val originalTitle: String,
    val title: String,
    val voteAverage: Double,
    val overview: String,
    val releaseDate: String
)