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
    val popularity: Double,
    val vote_count: Int,
    val video: Boolean,
    val poster_path: String?,
    val adult: Boolean,
    val backdrop_path: String?,
    val original_language: String,
    val original_title: String,
    val title: String,
    val vote_average: Double,
    val overview: String,
    val release_date: String) : Parcelable