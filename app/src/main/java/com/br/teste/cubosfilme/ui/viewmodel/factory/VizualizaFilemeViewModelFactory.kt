package com.br.teste.cubosfilme.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.br.teste.cubosfilme.repository.ResultadoRepository
import com.br.teste.cubosfilme.ui.viewmodel.VizualizaFilmeViewModel

class VizualizaFilemeViewModelFactory(private val repository: ResultadoRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return VizualizaFilmeViewModel(repository) as T
    }
}