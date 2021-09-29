package com.br.teste.cubosfilme.presentation.details

import androidx.lifecycle.ViewModel
import com.br.teste.cubosfilme.data.repository.ResultadoRepository

class MovieViewModel(
    private val id: Long,
    private val repository: ResultadoRepository): ViewModel() {

    var filmeEncontrado = repository.buscaPorId(id)
}