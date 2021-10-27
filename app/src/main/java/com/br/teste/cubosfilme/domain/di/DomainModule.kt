package com.br.teste.cubosfilme.domain.di

import com.br.teste.cubosfilme.domain.usercase.GetMovieListUserCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetMovieListUserCase(
            repository = get()
        )
    }
}