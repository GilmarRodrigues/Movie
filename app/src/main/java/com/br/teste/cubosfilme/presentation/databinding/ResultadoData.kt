package com.br.teste.cubosfilme.presentation.databinding

import androidx.lifecycle.MutableLiveData
import com.br.teste.cubosfilme.data.database.Resultado

class ResultadoData(
    private var resultado: Resultado = Resultado(),
    val popularity: MutableLiveData<Double> = MutableLiveData<Double>().also {
        it.value = resultado.popularity
    },
    val vote_count: MutableLiveData<Int> = MutableLiveData<Int>().also {
        it.value = resultado.vote_count
    },
    val video: MutableLiveData<Boolean> = MutableLiveData<Boolean>().also {
        it.value = resultado.video
    },
    val poster_path: MutableLiveData<String> = MutableLiveData<String>().also {
        it.value = resultado.poster_path
    },
    val adult: MutableLiveData<Boolean> = MutableLiveData<Boolean>().also {
        it.value = resultado.adult
    },
    val backdrop_path: MutableLiveData<String> = MutableLiveData<String>().also {
        it.value = resultado.backdrop_path
    },
    val original_language: MutableLiveData<String> = MutableLiveData<String>().also {
        it.value = resultado.original_language
    },
    val original_title: MutableLiveData<String> = MutableLiveData<String>().also {
        it.value = resultado.original_title
    },
    val title: MutableLiveData<String> = MutableLiveData<String>().also {
        it.value = resultado.title
    },
    val vote_average: MutableLiveData<Double> = MutableLiveData<Double>().also {
        it.value = resultado.vote_average
    },
    val overview: MutableLiveData<String> = MutableLiveData<String>().also {
        it.value = resultado.overview
    },
    val release_date: MutableLiveData<String> = MutableLiveData<String>().also {
        it.value = resultado.release_date
    }
) {

    fun atualiza(resultado: Resultado) {
        this.resultado = resultado
        popularity.postValue(this.resultado.popularity)
        vote_count.postValue(this.resultado.vote_count)
        video.postValue(this.resultado.video)
        poster_path.postValue(this.resultado.poster_path)
        adult.postValue(this.resultado.adult)
        backdrop_path.postValue(this.resultado.backdrop_path)
        original_language.postValue(this.resultado.original_language)
        original_title.postValue(this.resultado.original_title)
        title.postValue(this.resultado.title)
        vote_average.postValue(this.resultado.vote_average)
        overview.postValue(this.resultado.overview)
        release_date.postValue(this.resultado.release_date)
    }
}