package com.debcomp.aql.globoplaychallenge.ui.splash

import android.content.Intent
import android.os.Bundle
import com.debcomp.aql.globoplaychallenge.R
import com.debcomp.aql.globoplaychallenge.infra.BaseActivity
import com.debcomp.aql.globoplaychallenge.ui.home.HomeActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/*
 * Davi Áquila
 * aquiladvx
 *
 * 05/12/2020
 *
 */

class SplashScreenActivity: BaseActivity() {

    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        supportActionBar?.hide()

       activityScope.launch {
           delay(2500)

           val intent = Intent(this@SplashScreenActivity, HomeActivity::class.java)
           startActivity(intent)
           finish()
       }
    }
}