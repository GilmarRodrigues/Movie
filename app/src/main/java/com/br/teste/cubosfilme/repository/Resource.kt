package com.br.teste.cubosfilme.repository

import com.br.teste.cubosfilme.model.Resultado

class Resource<T>(
    val dado: T?,
    val erro: String? = null)

fun <T> criaResourcedeFalha(resourceAtual: Resource<T?>?,
                                erro: String?): Resource<T?> {
    if (resourceAtual != null) {
        return Resource(dado = resourceAtual.dado, erro = null)
    }
    return Resource(dado = null, erro = erro)
}