package com.example.movies.ui.favorite

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.IMAGE_URL
import com.example.movies.MAIN
import com.example.movies.R
import com.example.movies.data.model.ResultMovies
import kotlinx.android.synthetic.main.item_card.view.*

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private var listMovies = emptyList<ResultMovies>()

    class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.itemView.textTitle.text = listMovies[position].title
        holder.itemView.textData.text = listMovies[position].release_date

        Glide.with(MAIN)
            .load(IMAGE_URL + listMovies[position].poster_path)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.imageView)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<ResultMovies>) {
        listMovies = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: FavoriteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            FavoriteFragment.clickMovies(listMovies[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: FavoriteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}