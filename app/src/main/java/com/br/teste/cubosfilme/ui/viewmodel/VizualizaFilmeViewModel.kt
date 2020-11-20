package com.br.teste.cubosfilme.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.br.teste.cubosfilme.repository.ResultadoRepository

class VizualizaFilmeViewModel(private val repository: ResultadoRepository): ViewModel() {

    fun buscaPorId(id: Long) = repository.buscaPorId(id)
}