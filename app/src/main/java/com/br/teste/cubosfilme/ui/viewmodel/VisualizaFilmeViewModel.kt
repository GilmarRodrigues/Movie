package com.br.teste.cubosfilme.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.br.teste.cubosfilme.repository.ResultadoRepository

class VisualizaFilmeViewModel(
    private val id: Long,
    private val repository: ResultadoRepository): ViewModel() {

    var filmeEncontrado = repository.buscaPorId(id)
}