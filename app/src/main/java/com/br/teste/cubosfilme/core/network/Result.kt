package com.br.teste.cubosfilme.core.network

import java.lang.Exception

sealed class Result<out R> {
    data class Success<out T>(val data: T?) : Result<T?>()
    data class Error(val exception: String) : Result<Nothing>()
}
