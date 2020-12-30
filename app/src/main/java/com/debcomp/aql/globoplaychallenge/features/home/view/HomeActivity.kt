package com.debcomp.aql.globoplaychallenge.features.home.view

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.debcomp.aql.globoplaychallenge.R
import com.debcomp.aql.globoplaychallenge.features.home.model.HomeViewModel
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.Genre
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.Show
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.ShowGroup
import com.debcomp.aql.globoplaychallenge.infra.BaseActivity
import com.debcomp.aql.globoplaychallenge.infra.GPCApplication
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.sql.SQLClientInfoException
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class HomeActivity : BaseActivity() {

    private lateinit var listGenre: List<Genre>
    private lateinit var mAdapter: ShowGroupAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewModel: HomeViewModel
    private var showGroup: ArrayList<ShowGroup> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        viewModel = ViewModelProvider(
            this,
            HomeViewModel.HomeViewModelFactory(GPCApplication.instance)
        ).get(HomeViewModel::class.java)

        viewManager = LinearLayoutManager(this)
        mAdapter = ShowGroupAdapter(this)

        rv_shows.apply {
            layoutManager = viewManager
            adapter = mAdapter
        }

        setObservables()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getAllGenre()
        }


    }

    private fun setObservables() {
        viewModel.allGenre.observe(this, Observer {

            listGenre = it.genres
            getShowsGroup()


        })

        viewModel.showByGenre.observe(this, Observer {
            val genreName = it.keys.toString().replace("[", "").replace("]", "")
            val showList = it[genreName]
            setShows(genreName, showList?.shows)
        })
    }

    private fun getShowsGroup() {
        listGenre.forEach {genre ->
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.getShowsByGenre(genre)
            }
        }

    }

    private fun setShows(genreName: String, showList: List<Show>?) {
        if (showList != null) {
            val mShowGroup = ShowGroup(genreName, showList)
            showGroup.add(mShowGroup)
            mAdapter.submit(showGroup)
        }
    }


}