package com.br.teste.cubosfilme.data.di

import androidx.room.Room
import com.br.teste.cubosfilme.core.network.HttpClient
import com.br.teste.cubosfilme.data.api.dataset.MovieEventDataSet
import com.br.teste.cubosfilme.data.api.dataset.MovieEventDataSetImpl
import com.br.teste.cubosfilme.data.api.service.MovieService
import com.br.teste.cubosfilme.data.database.AppDatabase
import com.br.teste.cubosfilme.data.database.dao.MovieDao
import com.br.teste.cubosfilme.data.repository.MovieRepository
import com.br.teste.cubosfilme.data.repository.MovieRepositoryImpl
import org.koin.dsl.module

private const val NOME_BANCO_DADOS = "filme.db"

val dataModules = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            NOME_BANCO_DADOS
        ).build()
    }

    factory<MovieDao> {
        get<AppDatabase>().movieDao
    }

    factory {
        HttpClient.create(MovieService::class.java)
    }

    factory<MovieEventDataSet> {
        MovieEventDataSetImpl(
            service = get()
        )
    }
    factory<MovieRepository> {
        MovieRepositoryImpl(
            movieEventDataSet = get()
        )
    }
}