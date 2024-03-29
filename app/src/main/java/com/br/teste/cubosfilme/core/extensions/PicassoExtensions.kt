package com.br.teste.cubosfilme.core.extensions

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Picasso

fun ImageView.loadUrl(url: String?, progress: ProgressBar? = null) {
    if (url == null || url.trim().isEmpty()) {
        setImageBitmap(null)
        return
    }
    if (progress == null) {
        Picasso.get().load(url).fit().into(this)
    } else {
        progress.visibility = View.VISIBLE
        Picasso.get().load(url).fit().into(this,
            object : com.squareup.picasso.Callback {
                override fun onSuccess() {
                    progress.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    progress.visibility = View.GONE
                }
            })
    }
}