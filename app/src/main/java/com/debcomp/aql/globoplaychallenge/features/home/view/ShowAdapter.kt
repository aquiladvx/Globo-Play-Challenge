package com.debcomp.aql.globoplaychallenge.features.home.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.debcomp.aql.globoplaychallenge.R
import com.debcomp.aql.globoplaychallenge.features.details.DetailsAcivity
import com.debcomp.aql.globoplaychallenge.features.home.model.entity.Show
import com.debcomp.aql.globoplaychallenge.infra.Constants
import com.debcomp.aql.globoplaychallenge.infra.util.MyFileUtils


/*
 * Davi Áquila
 * aquiladvx
 *
 * 05/12/2020
 *
 */

class ShowAdapter internal constructor(context: Context, listShow: List<Show>)
    : RecyclerView.Adapter<ShowAdapter.ShowViewHolder>() {

    private val mContext = context
    private val inflater = LayoutInflater.from(context)
    private var shows = listShow

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val itemView = inflater.inflate(R.layout.item_shows_on_rv, parent, false)
        return ShowViewHolder(itemView)
    }

    override fun getItemCount() = shows.size

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder.bind(shows[position])
    }

    inner class ShowViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        private var mImgShow: ImageView = itemView.findViewById(R.id.img_show)

        fun bind(show: Show) {
            Glide.with(mContext)
                .load(Constants.WEB_SERVICE_IMAGE_200 + show.posterPath)
                .placeholder(R.drawable.home)
                .into(mImgShow)

            mImgShow.setOnClickListener {
                mContext.startActivity((DetailsAcivity.start(mContext, show.id)))
            }

        }

    }
}