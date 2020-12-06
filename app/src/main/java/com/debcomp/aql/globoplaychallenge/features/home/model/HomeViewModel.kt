package com.debcomp.aql.globoplaychallenge.features.home.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.debcomp.aql.globoplaychallenge.features.home.repository.HomeRepository


/*
 * Davi Áquila
 * aquiladvx
 *
 * 05/12/2020
 *
 */

class HomeViewModel(app: Application): AndroidViewModel(app) {


    private val homeRepo = HomeRepository(app)
}