package com.example.submission_github_user.services

import com.example.submission_github_user.models.MovieResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiService {

    private const val baseURL = "https://api.themoviedb.org/3/movie/"
    const val apiKey = "d407611be29fb837a1b17e4e981cae5c"

    private fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
             .build()
    }

    fun getService() = getRetrofit().create(ApiCall::class.java)

}

interface ApiCall {
    @GET("now_playing?api_key=${ApiService.apiKey}")
    fun getNowPlayingMovies(): Call<MovieResponse>

    @GET("top_rated?api_key=${ApiService.apiKey}")
    fun getTopRatedMovies(): Call<MovieResponse>

    @GET("popular?api_key=${ApiService.apiKey}")
    fun getPopularMovies(): Call<MovieResponse>
}