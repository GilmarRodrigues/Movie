package com.br.teste.cubosfilme.di

import com.br.teste.cubosfilme.data.di.dataModules
import com.br.teste.cubosfilme.domain.di.domainModule
import com.br.teste.cubosfilme.presentation.di.presentationModule
import org.koin.core.module.Module


val appModules: List<Module>
    get() = dataModules + domainModule + presentationModule
