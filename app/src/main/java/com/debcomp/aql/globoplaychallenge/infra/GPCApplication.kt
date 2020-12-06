package com.debcomp.aql.globoplaychallenge.infra

import android.app.Application


/*
 * Davi Áquila
 * aquiladvx
 *
 * 05/12/2020
 *
 */

class GPCApplication: Application(){


    companion object {
        lateinit var instance: GPCApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}