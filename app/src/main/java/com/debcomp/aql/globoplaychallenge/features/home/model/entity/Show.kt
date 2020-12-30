package com.debcomp.aql.globoplaychallenge.features.home.model.entity

import com.google.gson.annotations.SerializedName


/*
 * Davi Áquila
 * aquiladvx
 *
 * 05/12/2020
 *
 */


 
data class Show(
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    val name: String,
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_name")
    val originalName: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)


data class ShowList(
        @SerializedName("results")
        val shows: List<Show>
)
