package com.iug.qudsiapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.iug.qudsiapp.databinding.FragmentFavDetailsBinding

class FavDetailsFragment : Fragment() {

    private lateinit var binding: FragmentFavDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null){
            val args = FavDetailsFragmentArgs.fromBundle(requireArguments())
            binding.news = args.news
        }

        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}