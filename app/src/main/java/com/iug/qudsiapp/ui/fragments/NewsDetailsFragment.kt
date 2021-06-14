package com.iug.qudsiapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.iug.qudsiapp.R
import com.iug.qudsiapp.databinding.FragmentNewsDetailsBinding
import com.iug.qudsiapp.model.api.Article
import com.iug.qudsiapp.model.local_storage.News
import com.iug.qudsiapp.ui.view_models.LocalNewsViewModel
import java.util.*

class NewsDetailsFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailsBinding
    private lateinit var article: Article
    private val viewModel by lazy {
        ViewModelProvider(this)[LocalNewsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null){
            val args = NewsDetailsFragmentArgs.fromBundle(requireArguments())
            binding.news = args.news
            article = args.news
        }

        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.imgFav.setOnClickListener {
            val uuid = UUID.randomUUID()
            val news = News(
                uuid.toString(),
                article.urlToImage,
                article.title,
                article.description
            )
            viewModel.addNews(news)
            binding.imgFav.setImageResource(R.drawable.ic_star_fill)
            Snackbar.make(requireView(), "تم إضافة الخبر الى المفضلة بنجاح", Snackbar.LENGTH_SHORT).show()
        }
    }

}