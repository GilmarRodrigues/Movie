package com.br.teste.cubosfilme.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.br.teste.cubosfilme.model.Resultado
import com.br.teste.cubosfilme.repository.Resource
import com.br.teste.cubosfilme.repository.ResultadoRepository

class ListaFilmesViewModel(private val repository: ResultadoRepository) : ViewModel() {

    fun buscaTodos() : LiveData<Resource<List<Resultado>?>> {
        return repository.buscaTodos()
    }
}