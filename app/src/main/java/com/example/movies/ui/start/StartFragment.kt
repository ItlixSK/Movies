package com.example.movies.ui.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.MAIN
import com.example.movies.R
import com.example.movies.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var mBinding:FragmentStartBinding? = null
    private val  binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { StartAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentStartBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inite()
    }

    private fun inite() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        recyclerView = binding.startRecyclerView
        recyclerView.adapter = adapter
        try {
            viewModel.getMoviesRetrofit()
            viewModel.myMovies.observe(viewLifecycleOwner){
                list -> adapter.setList(list.body()!!.results)
            }
        }catch (e: Exception){
            Toast.makeText(MAIN,e.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}