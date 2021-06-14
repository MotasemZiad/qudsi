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
import com.iug.qudsiapp.adapters.SubjectsAdapter
import com.iug.qudsiapp.databinding.FragmentSubCityBinding
import com.iug.qudsiapp.ui.view_models.SubjectsViewModel

class SubCityFragment : Fragment() {

    private lateinit var binding: FragmentSubCityBinding
    private lateinit var adapter: SubjectsAdapter
    private val viewModel by lazy {
        ViewModelProvider(this)[SubjectsViewModel::class.java]
    }

    private var id = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSubCityBinding.inflate(layoutInflater)
        if (arguments != null){
            val args = SubCityFragmentArgs.fromBundle(requireArguments())
            binding.textView6.text = args.title.name
            id = args.title.id
        }
        getSubjects()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }

        adapter = SubjectsAdapter {
            val action = SubCityFragmentDirections.actionSubCityFragmentToSubCityDetailsFragment(it)
            findNavController().navigate(action)
        }
        binding.rcSubjects.adapter = adapter
        binding.rcSubjects.layoutManager = LinearLayoutManager(requireContext())
        binding.rcSubjects.startAnimation(
            AnimationUtils.loadAnimation(
                requireContext(),
                R.anim.recyclerview_animation
            )
        )
        viewModel.getSubjects(id)
    }

    private fun getSubjects() {
        viewModel.dataSubjects.observe(viewLifecycleOwner,
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