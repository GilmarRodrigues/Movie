package com.br.teste.cubosfilme.presentation.details

import androidx.lifecycle.ViewModel
import com.br.teste.cubosfilme.data.repository.MovieRepository
import com.br.teste.cubosfilme.data.repository.MovieRepositoryImpl

class MovieDetailsViewModel(
    private val id: Long,
    private val repository: MovieRepository
): ViewModel() {
}