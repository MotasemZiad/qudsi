package com.iug.qudsiapp.ui.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.iug.qudsiapp.R
import com.iug.qudsiapp.databinding.FragmentSettingBinding
import com.iug.qudsiapp.util.Commons

class SettingFragment : Fragment() {

    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isNightTheme = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (isNightTheme) {
            Configuration.UI_MODE_NIGHT_YES -> {
                binding.switchTheme.isChecked = false
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                binding.switchTheme.isChecked = true
            }
        }

        binding.switchTheme.setOnCheckedChangeListener { _, _ ->
            when (isNightTheme) {
                Configuration.UI_MODE_NIGHT_YES -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    Commons.getSharedEditor(requireContext()).putBoolean(Commons.IS_NIGHT, false).apply()
                }
                Configuration.UI_MODE_NIGHT_NO -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    Commons.getSharedEditor(requireContext()).putBoolean(Commons.IS_NIGHT, true).apply()
                }
            }
        }

    }

}