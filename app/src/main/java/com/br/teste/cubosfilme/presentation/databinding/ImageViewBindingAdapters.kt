package com.br.teste.cubosfilme.presentation.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.br.teste.cubosfilme.presentation.extensions.loadUrl

private const val URL_BASE_IMG = "https://image.tmdb.org/t/p/w500/"

@BindingAdapter("carregaImagem")
fun ImageView.carregaImagemUrl(url: String?) {
    url?.let { loadUrl("$URL_BASE_IMG$url") }
}