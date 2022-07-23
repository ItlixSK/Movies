package com.example.movies.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.movies.IMAGE_URL
import com.example.movies.MAIN
import com.example.movies.R
import com.example.movies.data.SaveMovies
import com.example.movies.data.model.ResultMovies
import com.example.movies.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private var mBinding: FragmentDetailBinding? = null
    private val binding get() = mBinding!!
    lateinit var currentMovies: ResultMovies
    private var isFavorite = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentMovies = arguments?.getSerializable("movie") as ResultMovies
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val valueBool = SaveMovies.getFavorite(MAIN, currentMovies.id.toString())
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        if (isFavorite !== valueBool) {
            binding.iconFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            binding.iconFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
        Glide.with(MAIN)
            .load(IMAGE_URL + currentMovies.poster_path)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imageMoviesDetail)
        binding.titleMovies.text = currentMovies.title
        binding.dataMovies.text = currentMovies.release_date
        binding.descriptionMovies.text = currentMovies.overview

        binding.iconFavorite.setOnClickListener {
            if (isFavorite == valueBool) {
                binding.iconFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                SaveMovies.setFavorite(MAIN, currentMovies.id.toString(), true)
                viewModel.insert(currentMovies) {}
                isFavorite = true
            } else {
                binding.iconFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                SaveMovies.setFavorite(MAIN, currentMovies.id.toString(), false)
                viewModel.delete(currentMovies) {}
                isFavorite = false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}