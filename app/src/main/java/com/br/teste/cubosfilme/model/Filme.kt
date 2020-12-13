package com.br.teste.cubosfilme.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
class Filme(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: MutableList<Resultado>): Parcelable

@Parcelize
@Entity
class Resultado(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val popularity: Double = 0.0,
    val vote_count: Int = 0,
    val video: Boolean = false,
    val poster_path: String? = "",
    val adult: Boolean = false,
    val backdrop_path: String? = "",
    val original_language: String = "",
    val original_title: String = "",
    val title: String = "",
    val vote_average: Double = 0.0,
    val overview: String = "",
    val release_date: String = "") : Parcelable