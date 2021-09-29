package com.br.teste.cubosfilme.di.modules

import androidx.room.Room
import com.br.teste.cubosfilme.data.api.webclient.FilmeWebClient
import com.br.teste.cubosfilme.data.database.AppDatabase
import com.br.teste.cubosfilme.data.database.ResultadoDAO
import com.br.teste.cubosfilme.data.repository.ResultadoRepository
import com.br.teste.cubosfilme.presentation.list.adapter.FilmesAdapter
import com.br.teste.cubosfilme.presentation.list.ListaFilmesViewModel
import com.br.teste.cubosfilme.presentation.details.VisualizaFilmeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val NOME_BANCO_DADOS = "filme.db"

val appModules = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            NOME_BANCO_DADOS
        ).build()
    }
    single<ResultadoDAO> {
        get<AppDatabase>().resultadoDAO
    }
    single<FilmeWebClient> {
        FilmeWebClient()
    }
    single<ResultadoRepository> {
        ResultadoRepository(get(), get())
    }
    viewModel<ListaFilmesViewModel> {
        ListaFilmesViewModel(get())
    }
    viewModel<VisualizaFilmeViewModel> { (id: Long) ->
        VisualizaFilmeViewModel(id, get())
    }
    factory<FilmesAdapter> { FilmesAdapter(get()) }
}