package com.br.teste.cubosfilme.ui.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.br.teste.cubosfilme.ui.activity.extensions.loadUrl
import com.br.teste.cubosfilme.utils.URL_BASE_IMG
import kotlinx.android.synthetic.main.adapter_filmes.view.*

@BindingAdapter("carregaImagem")
fun ImageView.carregaImagemUrl(url: String?) {
    url?.let { loadUrl("$URL_BASE_IMG$url") }
}