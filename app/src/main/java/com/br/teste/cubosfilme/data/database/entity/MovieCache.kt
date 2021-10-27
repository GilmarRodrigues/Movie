package com.br.teste.cubosfilme.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieCache(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val popularity: Double,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int,
    val video: Boolean = false,
    @ColumnInfo(name = "poster_path")
    val posterPath: String?,
    val adult: Boolean = false,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,
    @ColumnInfo(name = "original_title")
    val originalTitle: String,
    val title: String,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,
    val overview: String,
    @ColumnInfo(name = "release_date")
    val releaseDate: String
)