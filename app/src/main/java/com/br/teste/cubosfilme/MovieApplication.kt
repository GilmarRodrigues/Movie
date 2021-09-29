package com.br.teste.cubosfilme

import android.app.Application
import com.br.teste.cubosfilme.di.modules.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApplication)
            modules(appModules)
            //teste
        }
    }
}