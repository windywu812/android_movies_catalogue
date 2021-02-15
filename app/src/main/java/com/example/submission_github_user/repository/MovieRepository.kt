package com.example.submission_github_user.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.submission_github_user.models.MovieModel
import com.example.submission_github_user.models.MovieResponse
import com.example.submission_github_user.services.ApiService
import retrofit2.Call
import retrofit2.Response

object MovieRepository {

    var nowPlayingMovies: MutableLiveData<List<MovieModel>> = MutableLiveData()
    var topRatedMovies: MutableLiveData<List<MovieModel>> = MutableLiveData()
    val popularMovies: MutableLiveData<List<MovieModel>> = MutableLiveData()

    init {
        getNowPlayingMovies()
        getTopRatedMovies()
        getPopularMovies()
    }

    private fun getNowPlayingMovies() {
        ApiService.getService()
            .getNowPlayingMovies()
            .enqueue(object : retrofit2.Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    nowPlayingMovies.value = response.body()?.results
                }
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    nowPlayingMovies.value = emptyList()
                    Log.d("debug", t.localizedMessage)
                }
            })
    }

    private fun getTopRatedMovies() {
        ApiService.getService()
            .getTopRatedMovies()
            .enqueue(object : retrofit2.Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    topRatedMovies.value = response.body()?.results
                }
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    topRatedMovies.value = emptyList()
                    Log.d("debug", t.localizedMessage)
                }
            })
    }

    private fun getPopularMovies() {
        ApiService.getService()
            .getPopularMovies()
            .enqueue(object : retrofit2.Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    popularMovies.value = response.body()?.results
                }
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    popularMovies.value = emptyList()
                    Log.d("debug", t.localizedMessage)
                }
            })
    }

}