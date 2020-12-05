package com.debcomp.aql.globoplaychallenge.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.debcomp.aql.globoplaychallenge.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
    }
}