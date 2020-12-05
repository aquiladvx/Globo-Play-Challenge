package com.debcomp.aql.globoplaychallenge.features.home.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.debcomp.aql.globoplaychallenge.R
import com.debcomp.aql.globoplaychallenge.features.home.model.ShowGroup


/*
 * Davi Áquila
 * aquiladvx
 *
 * 05/12/2020
 *
 */

class ShowsAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<ShowsAdapter.ShowsViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private var shows = emptyList<ShowGroup>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowsViewHolder {
        val itemView = inflater.inflate(R.layout.item_shows, parent, false)
        return ShowsViewHolder(itemView)
    }

    override fun getItemCount() = shows.size

    override fun onBindViewHolder(holder: ShowsViewHolder, position: Int) {
        holder.bind(shows[position])
    }

    internal fun submit(newShowGroup: List<ShowGroup>) {
        shows = newShowGroup
        notifyDataSetChanged()
    }

    inner class ShowsViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        private var mTitleView: TextView? = null
        private var mYearView: RecyclerView? = null


        init {
            mTitleView = itemView.findViewById(R.id.tv_title_group_shows)
            mYearView = itemView.findViewById(R.id.rv_shows)
        }

        fun bind(showGroup: ShowGroup) {
            mTitleView?.text = showGroup.title
        }

    }
}
