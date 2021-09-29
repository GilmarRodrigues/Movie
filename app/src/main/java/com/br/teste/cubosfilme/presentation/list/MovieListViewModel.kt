package com.br.teste.cubosfilme.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.br.teste.cubosfilme.data.api.Resource
import com.br.teste.cubosfilme.data.database.Resultado
import com.br.teste.cubosfilme.data.repository.ResultadoRepository

class MovieListViewModel(private val repository: ResultadoRepository) : ViewModel() {

    fun buscaTodos(): LiveData<Resource<List<Resultado>?>> {
        return repository.buscaTodos()
    }
}