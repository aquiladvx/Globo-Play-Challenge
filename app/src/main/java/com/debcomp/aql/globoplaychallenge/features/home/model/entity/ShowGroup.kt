package com.debcomp.aql.globoplaychallenge.features.home.model.entity

import com.debcomp.aql.globoplaychallenge.features.home.model.entity.Show


/*
 * Davi Áquila
 * aquiladvx
 *
 * 05/12/2020
 *
 */
 
data class ShowGroup(
        val genre: String,
        val shows: List<Show>
)