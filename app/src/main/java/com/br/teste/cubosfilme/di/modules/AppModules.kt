package com.br.teste.cubosfilme.di.modules

import androidx.room.Room
import com.br.teste.cubosfilme.repository.AppDatabase
import com.br.teste.cubosfilme.repository.ResultadoRepository
import com.br.teste.cubosfilme.repository.dao.ResultadoDAO
import com.br.teste.cubosfilme.retrofit.webclient.FilmeWebClient
import com.br.teste.cubosfilme.ui.adapter.FilmesAdapter
import com.br.teste.cubosfilme.ui.viewmodel.ListaFilmesViewModel
import com.br.teste.cubosfilme.ui.viewmodel.VisualizaFilmeViewModel
import org.koin.android.viewmodel.dsl.viewModel
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
    factory<FilmesAdapter> { FilmesAdapter(get())  }
}