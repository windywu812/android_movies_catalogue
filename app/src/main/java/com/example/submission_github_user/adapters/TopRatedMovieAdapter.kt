package com.example.submission_github_user.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission_github_user.databinding.ItemMediumCellBinding
import com.example.submission_github_user.interfaces.OnItemClickCallback
import com.example.submission_github_user.models.MovieModel

class TopRatedMovieAdapter(private val data: List<MovieModel>, private val onItemClickCallback: OnItemClickCallback) : RecyclerView.Adapter<TopRatedMovieAdapter.ViewHolder>() {

    private var mMovie: List<MovieModel> = data
    private var urlImageLoader: String = "https://image.tmdb.org/t/p/w500/"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMovieAdapter.ViewHolder {
        val binding = ItemMediumCellBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mMovie.size
    }

    override fun onBindViewHolder(holder: TopRatedMovieAdapter.ViewHolder, position: Int) {
        with(holder) {
            with(mMovie[position]) {

                Glide.with(holder.itemView.context)
                    .load(urlImageLoader + backdropPath)
                    .into(holder.binding.imageBackdrop)

                binding.title.text = title
                binding.description.text = overview

                holder.binding.root.setOnClickListener {
                    onItemClickCallback.onItemClicked(this)
                }
            }
        }
    }

    inner class ViewHolder(val binding: ItemMediumCellBinding) : RecyclerView.ViewHolder(binding.root)

}