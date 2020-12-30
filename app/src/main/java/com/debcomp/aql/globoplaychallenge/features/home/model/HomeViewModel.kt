package com.debcomp.aql.globoplaychallenge.features.home.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.debcomp.aql.globoplaychallenge.features.home.data.repository.HomeRepository
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.Genre
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.ShowList
import com.debcomp.aql.globoplaychallenge.infra.util.MyFileUtils
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope


/*
 * Davi Áquila
 * aquiladvx
 *
 * 05/12/2020
 *
 */

class HomeViewModel(app: Application): AndroidViewModel(app) {

    private var apiKey: String = MyFileUtils.readFile(app)
    private val homeRepo = HomeRepository(app)

    val allGenre = homeRepo.allGenreResponse
    val showByGenre = homeRepo.showsByGenreResponse

    suspend fun getAllGenre() {
        homeRepo.getAllGenre(apiKey)
    }

    suspend fun getShowsByGenre(genre: Genre) {
        homeRepo.getShowsByGenre(apiKey, genre)
    }

    class HomeViewModelFactory constructor(private val application: Application) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                HomeViewModel(this.application) as T
            } else {
                throw IllegalArgumentException("ViewModel not found")
            }
        }
    }
}