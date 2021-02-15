package com.example.submission_github_user.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission_github_user.databinding.ItemLargeCellBinding
import com.example.submission_github_user.interfaces.OnItemClickCallback
import com.example.submission_github_user.models.MovieModel

class NowPlayingMovieAdapter(private val data: List<MovieModel>, private val onItemClickCallback: OnItemClickCallback) : RecyclerView.Adapter<NowPlayingMovieAdapter.ViewHolder>() {

    private var mMovie: List<MovieModel> = data
    private var urlImageLoader: String = "https://image.tmdb.org/t/p/w500/"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingMovieAdapter.ViewHolder {
        val binding = ItemLargeCellBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mMovie.size
    }

    override fun onBindViewHolder(holder: NowPlayingMovieAdapter.ViewHolder, position: Int) {
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

    inner class ViewHolder(val binding: ItemLargeCellBinding) : RecyclerView.ViewHolder(binding.root)

}