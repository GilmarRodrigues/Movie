package com.br.teste.cubosfilme.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class Filme(val page: Int, val total_results: Int, val total_pages: Int, val results: MutableList<Resultado>)

@Parcelize
class Resultado(val id: Long, val popularity: Float, val vote_count: Int, val video: Boolean,
                val poster_path: String, val adult: Boolean, val backdrop_path: String,
                val original_language: String, val original_title: String, val genre_ids: MutableList<Int>,
                val title: String, val vote_average: Float, val overview: String, val release_date: String) : Parcelable