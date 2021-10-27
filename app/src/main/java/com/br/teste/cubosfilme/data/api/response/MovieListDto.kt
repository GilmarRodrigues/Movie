package com.br.teste.cubosfilme.data.api.response

import com.google.gson.annotations.SerializedName

data class MovieListDto(
    @SerializedName("page") val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val movies: List<MovieDto> = mutableListOf()
)
