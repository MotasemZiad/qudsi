package com.iug.qudsiapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.iug.qudsiapp.R
import com.iug.qudsiapp.adapters.TitlesAdapter
import com.iug.qudsiapp.databinding.FragmentCityBinding
import com.iug.qudsiapp.ui.view_models.TitlesViewModel

class CityFragment : Fragment() {

    private lateinit var binding: FragmentCityBinding
    private lateinit var adapter: TitlesAdapter
    private val viewModel by lazy {
        ViewModelProvider(this)[TitlesViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityBinding.inflate(layoutInflater)
        getTitles()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TitlesAdapter {
            val action = CityFragmentDirections.actionCityFragmentToSubCityFragment(it)
            findNavController().navigate(action)
        }
        binding.rcTitles.adapter = adapter
        binding.rcTitles.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rcTitles.startAnimation(
            AnimationUtils.loadAnimation(
                requireContext(),
                R.anim.recyclerview_animation
            )
        )
        viewModel.getTitles()
    }

    private fun getTitles() {
        viewModel.dataTitles.observe(viewLifecycleOwner,
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