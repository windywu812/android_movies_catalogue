package com.example.submission_github_user.interfaces
import com.example.submission_github_user.models.MovieModel

interface OnItemClickCallback {
    fun onItemClicked(movie: MovieModel)
}