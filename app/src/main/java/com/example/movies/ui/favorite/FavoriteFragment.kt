package com.example.movies.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.MAIN
import com.example.movies.R
import com.example.movies.data.model.ResultMovies
import com.example.movies.databinding.FragmentFavoritBinding

class FavoriteFragment : Fragment() {

    private var mBinding: FragmentFavoritBinding? = null
    private val binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { FavoriteAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFavoritBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)
        recyclerView = binding.favoriteRecyclerView
        recyclerView.adapter = adapter
        viewModel.getAllMovies().observe(viewLifecycleOwner){
            list -> adapter.setList(list.asReversed())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

    companion object{
        fun clickMovies(model:ResultMovies){
            val bundle = Bundle()
            bundle.putSerializable("movie",model)
            MAIN.navController.navigate(R.id.action_favoriteFragment2_to_detailFragment2,bundle)
        }
    }
}