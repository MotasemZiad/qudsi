package com.iug.qudsiapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.iug.qudsiapp.R
import com.iug.qudsiapp.adapters.LocalNewsAdapter
import com.iug.qudsiapp.adapters.NewsAdapter
import com.iug.qudsiapp.databinding.FragmentFavoriteBinding
import com.iug.qudsiapp.ui.view_models.LocalNewsViewModel

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var adapter: LocalNewsAdapter
    private val viewModel by lazy {
        ViewModelProvider(this)[LocalNewsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = LocalNewsAdapter { news ->
            val action = FavoriteFragmentDirections.actionFavoriteFragmentToFavDetailsFragment(news)
            findNavController().navigate(action)
        }
        binding.rcNews.adapter = adapter
        binding.rcNews.layoutManager = LinearLayoutManager(requireContext())
        binding.rcNews.startAnimation(
            AnimationUtils.loadAnimation(
                requireContext(),
                R.anim.recyclerview_animation
            )
        )
        getNews()
    }

    private fun getNews() {
        viewModel.dataNews.observe(viewLifecycleOwner,
            { response ->
                if (response != null) {
                    adapter.data.clear()
                    adapter.data.addAll(response)
                    adapter.notifyDataSetChanged()
                } else {
                    Snackbar.make(requireView(), "نأسف حصلت مشكلة ما!!", Snackbar.LENGTH_SHORT)
                        .show()
                }
            })
    }

}