package com.debcomp.aql.globoplaychallenge.features.home.data.service

import com.debcomp.aql.globoplaychallenge.features.home.model.entity.Genre
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.GenreList
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.ShowGroup
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.ShowList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/*
 * Davi Áquila
 * aquiladvx
 *
 * 05/12/2020
 *
 */
interface ShowService {

    @GET("genre/tv/list")
    fun getAllGenre(
        @Query("api_key")apiKey: String,
        @Query("language")language: String = "pt-BR"
    ): Call<GenreList>

    @GET("discover/tv")
    fun getShowByGenre(
        @Query("api_key")apiKey: String,
        @Query("language")language: String = "pt-BR",
        @Query("with_genres")genreId: Int
    ): Call<ShowList>

//    //Post example with param
//    @POST("user")
//    suspend fun getUser(
//        @Query("id")id: Int
//    ): Response<List<User>>
//
//    //Post example with body
//    @POST("user/new")
//    suspend fun registerUser(
//        @Body user: User
//    ): Response<List<User>>
}