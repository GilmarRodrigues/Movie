package com.br.teste.cubosfilme.rest

import android.content.Context
import android.util.Log
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.utils.Util
import com.br.teste.cubosfilme.model.Filme
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.toast

object FilmeRest {
    private val TAG = FilmeRest::class.java.simpleName

    fun filmesPorGeneros(context: Context, apiToken: String, idioma: String, generoId: Int,
                         success: (Filme) -> Unit, failure: (Throwable) -> Unit){
        if (!Util.isOnline(context)) {
            context.toast(context.getString(R.string.erro_sem_conexao))
            return
        }

        val consultorApi = FilmeClient.createClientV1(FilmeAPI::class.java).filmesPorGenero(apiToken, idioma, generoId)
        Log.i(TAG, "filmesPorGeneros().URL ${consultorApi.request().url()}")

        consultorApi.enqueue(callback { response, throwable ->
            response?.let {
                if (response.isSuccessful) {
                    it.body()?.let {
                        success(it)
                        Log.i(TAG, "filmesPorGeneros().success ${it.results}")
                    }
                } else {
                    Log.i(TAG, "filmesPorGeneros().error ${it.errorBody()?.string()}")
                }
            }
            throwable?.let {
                failure(it)
                Log.e(TAG, "filmesPorGeneros().throwable", it)
            }
        })
    }

    fun filmesPorTitulo(context: Context, apiToken: String, idioma: String, titulo: String,
                        success: (Filme) -> Unit, failure: (Throwable) -> Unit){
        if (!Util.isOnline(context)) {
            context.toast(context.getString(R.string.erro_sem_conexao))
            return
        }

        val consultorApi = FilmeClient.createClientV1(FilmeAPI::class.java).filmesPorTitulo(apiToken, idioma, titulo)
        Log.i(TAG, "filmesPorTitulo().URL ${consultorApi.request().url()}")

        val progress = context.indeterminateProgressDialog(context.getString(R.string.msg_aguarde), context.getString(R.string.app_name))
        progress.show()

        consultorApi.enqueue(callback { response, throwable ->
            response?.let {
                if (response.isSuccessful) {
                    it.body()?.let {
                        success(it)
                        Log.i(TAG, "filmesPorTitulo().success ${it.results}")
                    }
                } else {
                    Log.i(TAG, "filmesPorTitulo().error ${it.errorBody()?.string()}")
                }
            }
            throwable?.let {
                failure(it)
                Log.e(TAG, "filmesPorTitulo().throwable", it)
            }
            progress.hide()
        })
    }

}