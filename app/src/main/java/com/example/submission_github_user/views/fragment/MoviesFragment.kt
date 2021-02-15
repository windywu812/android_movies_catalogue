package com.example.submission_github_user.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission_github_user.adapters.NowPlayingMovieAdapter
import com.example.submission_github_user.adapters.PopularMovieAdapter
import com.example.submission_github_user.adapters.TopRatedMovieAdapter
import com.example.submission_github_user.databinding.FragmentMoviesBinding
import com.example.submission_github_user.interfaces.OnItemClickCallback
import com.example.submission_github_user.models.MovieModel
import com.example.submission_github_user.viewmodels.MovieViewModel

class MoviesFragment : Fragment(), OnItemClickCallback {

    private lateinit var viewModel: MovieViewModel
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var adapterNowPlaying: NowPlayingMovieAdapter
    private lateinit var adapterPopular: PopularMovieAdapter
    private lateinit var adapterTopRated: TopRatedMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMoviesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        viewModel.nowPlayingMovies.observe(this, {
            adapterNowPlaying = NowPlayingMovieAdapter(it, this)
            binding.rvNowPlaying.apply {
                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                adapter = adapterNowPlaying
            }
        })

        viewModel.topRatedMovies.observe(this, {
            adapterTopRated = TopRatedMovieAdapter(it, this)
            binding.rvTopRated.apply {
                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                adapter = adapterTopRated
            }
        })

        viewModel.popularMovies.observe(this, {
            adapterPopular = PopularMovieAdapter(it, this)
            binding.rvPopular.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = adapterPopular
            }
        })
    }

    override fun onItemClicked(movie: MovieModel) {
//        Toast.makeText(activity, "$movie", Toast.LENGTH_SHORT).show()
//        val intent = Intent(this@MainActivity, DetailActivity::class.java)
//        intent.putExtra(DetailActivity.DETAIL_USER, movie)
//        startActivity(intent)
    }

}
