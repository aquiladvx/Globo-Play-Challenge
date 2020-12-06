package com.debcomp.aql.globoplaychallenge.features.home.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.debcomp.aql.globoplaychallenge.R
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.ShowGroup


/*
 * Davi Áquila
 * aquiladvx
 *
 * 05/12/2020
 *
 */

class ShowGroupAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<ShowGroupAdapter.ShowGroupViewHolder>() {

    private val mContext = context
    private val inflater = LayoutInflater.from(context)
    private var shows = emptyList<ShowGroup>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowGroupViewHolder {
        val itemView = inflater.inflate(R.layout.item_shows, parent, false)
        return ShowGroupViewHolder(itemView)
    }

    override fun getItemCount() = shows.size

    override fun onBindViewHolder(holder: ShowGroupViewHolder, position: Int) {
        val ok = holder.bind(shows[position])

        val grupoShow = shows[holder.adapterPosition]
    }

    internal fun submit(newShowGroup: List<ShowGroup>) {
        shows = newShowGroup
        notifyDataSetChanged()
    }

    inner class ShowGroupViewHolder(itemView: View)
        :RecyclerView.ViewHolder(itemView) {
        private var mTitleView: TextView? = null
        private var mRvShows: RecyclerView? = null
        init {
            mTitleView = itemView.findViewById(R.id.tv_title_group_shows)
            mRvShows = itemView.findViewById(R.id.rv_shows_on_rv)
        }

        fun bind(showGroup: ShowGroup) {
            mTitleView?.text = showGroup.title

            val viewManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
            val mAdapter = ShowAdapter(mContext, showGroup.shows)

            mRvShows!!.apply {
                layoutManager = viewManager
                adapter = mAdapter
            }

        }

    }
}
