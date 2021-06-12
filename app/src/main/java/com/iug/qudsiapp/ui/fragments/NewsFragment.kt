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
import com.iug.qudsiapp.adapters.NewsAdapter
import com.iug.qudsiapp.databinding.FragmentNewsBinding
import com.iug.qudsiapp.ui.view_models.NewsViewModel
import java.text.Annotation

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var adapter : NewsAdapter
    private val viewModel by lazy {
        ViewModelProvider(this)[NewsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(layoutInflater)
        getNews()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NewsAdapter { article ->
            val action = NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment(article)
            findNavController().navigate(action)
        }
        binding.rcNews.adapter = adapter
        binding.rcNews.layoutManager = LinearLayoutManager(requireContext())
        binding.rcNews.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.recyclerview_animation))
        viewModel.getHomeNews()
    }

    private fun getNews() {
        viewModel.dataNews.observe(viewLifecycleOwner,
            {response ->
                if (response != null){
                    if (response.status == "ok"){
                        adapter.data.clear()
                        adapter.data.addAll(response.articles)
                        adapter.notifyDataSetChanged()
                    } else {
                        Snackbar.make(requireView(), "نأسف حصلت مشكلة ما!!", Snackbar.LENGTH_SHORT).show()
                    }
                }
            })
    }

}