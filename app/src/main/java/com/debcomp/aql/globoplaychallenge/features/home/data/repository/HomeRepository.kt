package com.debcomp.aql.globoplaychallenge.features.home.data.repository

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.debcomp.aql.globoplaychallenge.features.home.data.service.ShowService
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.Genre
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.GenreList
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.ShowGroup
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.ShowList
import com.debcomp.aql.globoplaychallenge.infra.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


/*
 * Davi Áquila
 * aquiladvx
 *
 * 05/12/2020
 *
 */
private val ERROR_API = "ERROR_API"
private val OK_API = "OK_API"
class HomeRepository(private val app: Application) {

    val allGenreResponse = MutableLiveData<GenreList>()
    val showsByGenreResponse = MutableLiveData<Map<String, ShowList?>>()

    @WorkerThread
    suspend fun getAllGenre(apiKey: String) {
        if (networkAvailable(app)) {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.WEB_SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit
                .create(ShowService::class.java)
            val serviceData = service
                .getAllGenre(apiKey)

            serviceData.enqueue(object : Callback<GenreList> {
                override fun onResponse(call: Call<GenreList>, response: Response<GenreList>) {
                    allGenreResponse.postValue(response.body())
                }

                override fun onFailure(call: Call<GenreList>, t: Throwable) {
                    Log.e("Error", t.message!!)
                }
            })
        }
    }

    @WorkerThread
    suspend fun getShowsByGenre(apiKey: String, genre: Genre) {
        if (networkAvailable(app)) {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.WEB_SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit
                .create(ShowService::class.java)
            val serviceData = service
                .getShowByGenre(
                    apiKey = apiKey,
                    genreId = genre.id
                )

            serviceData.enqueue(object: Callback<ShowList>{
                override fun onFailure(call: Call<ShowList>, t: Throwable) {
                    Log.e(ERROR_API, t.message?: "empty")
                }

                override fun onResponse(call: Call<ShowList>, response: Response<ShowList>) {
                    Log.i(OK_API, "${genre.name} with ${response.body()!!.shows.size} shows")
                    showsByGenreResponse.postValue(mapOf(Pair(genre.name, response.body())))
                }

            })
        }
    }



    private fun networkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }
}
