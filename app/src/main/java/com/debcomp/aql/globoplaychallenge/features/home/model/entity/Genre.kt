package com.debcomp.aql.globoplaychallenge.features.home.model.entity

import com.google.gson.annotations.SerializedName


/*
 * Davi Áquila
 * aquiladvx
 *
 * 05/12/2020
 *
 */

data class Genre(
    val id: Int,
    val name: String
)

data class GenreList(
    @SerializedName("genres")
    var genres: List<Genre>
)