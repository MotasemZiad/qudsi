package com.iug.qudsiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.iug.qudsiapp.R
import com.iug.qudsiapp.databinding.ItemNewsBinding
import com.iug.qudsiapp.model.api.Article

class NewsAdapter(val onClick: (article: Article) -> Unit) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var data = ArrayList<Article>()

    inner class ViewHolder(private val binding : ItemNewsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(article: Article) {
            binding.news = article
            binding.cardNews.setOnClickListener {
                onClick(article)
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding : ItemNewsBinding = DataBindingUtil.inflate(inflater, R.layout.item_news, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}