package com.br.teste.cubosfilme.presentation.dataui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDataUi(
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
) : Parcelable