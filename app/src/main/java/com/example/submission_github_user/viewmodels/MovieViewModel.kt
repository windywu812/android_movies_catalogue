package com.example.submission_github_user.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submission_github_user.models.MovieModel
import com.example.submission_github_user.repository.MovieRepository

class MovieViewModel: ViewModel() {

    var nowPlayingMovies: MutableLiveData<List<MovieModel>> = MutableLiveData()
    var topRatedMovies: MutableLiveData<List<MovieModel>> = MutableLiveData()
    var popularMovies: MutableLiveData<List<MovieModel>> = MutableLiveData()

    init {
        getNowPlaying()
        getTopRated()
        getPopular()
    }

    private fun getNowPlaying() {
        nowPlayingMovies = MovieRepository.nowPlayingMovies
    }

    private fun getTopRated() {
        topRatedMovies = MovieRepository.topRatedMovies
    }

    private fun getPopular() {
        popularMovies = MovieRepository.popularMovies
    }

}