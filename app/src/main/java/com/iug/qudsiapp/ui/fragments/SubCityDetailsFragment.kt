package com.iug.qudsiapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.iug.qudsiapp.R
import com.iug.qudsiapp.databinding.FragmentSubCityBinding
import com.iug.qudsiapp.databinding.FragmentSubCityDetailsBinding

class SubCityDetailsFragment : Fragment() {

    private lateinit var binding: FragmentSubCityDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSubCityDetailsBinding.inflate(layoutInflater)
        if (arguments != null){
            val args = SubCityDetailsFragmentArgs.fromBundle(requireArguments())
            binding.subject = args.subject
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }

    }

}