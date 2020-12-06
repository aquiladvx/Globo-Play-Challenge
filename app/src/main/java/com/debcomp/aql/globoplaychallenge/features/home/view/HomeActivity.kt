package com.debcomp.aql.globoplaychallenge.features.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.debcomp.aql.globoplaychallenge.R
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.Show
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.ShowGroup
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var mAdapter: ShowGroupAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        viewManager = LinearLayoutManager(this)
        mAdapter = ShowGroupAdapter(this)

        rv_shows.apply {
            layoutManager = viewManager
            adapter = mAdapter
        }

        val listS = ArrayList<Show>()
        listS.add(
            Show(
                "https://source.unsplash.com/random",
                1
            )
        )
        listS.add(
            Show(
                "https://source.unsplash.com/random",
                2
            )
        )
        listS.add(
            Show(
                "https://source.unsplash.com/random",
                3
            )
        )
        listS.add(
            Show(
                "https://source.unsplash.com/random",
                4
            )
        )
        listS.add(
            Show(
                "https://source.unsplash.com/random",
                5
            )
        )
        listS.add(
            Show(
                "https://source.unsplash.com/random",
                6
            )
        )
        listS.add(
            Show(
                "https://source.unsplash.com/random",
                7
            )
        )
        val list = ArrayList<ShowGroup>()
        list.add(
            ShowGroup(
                "Terror",
                listS
            )
        )
        list.add(
            ShowGroup(
                "Comedia",
                listS
            )
        )
        list.add(
            ShowGroup(
                "Romance",
                listS
            )
        )
        list.add(
            ShowGroup(
                "Anime",
                listS
            )
        )

        mAdapter.submit(list)

    }
}