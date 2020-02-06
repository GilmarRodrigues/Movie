package com.br.teste.cubosfilme.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.ui.adapter.TabsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configuraTabs()
    }

    private fun configuraTabs() {
        val tabsAdapter = TabsAdapter(this, supportFragmentManager)
        view_pager.adapter = tabsAdapter
        tabs.setupWithViewPager(view_pager)
    }
}