package com.iug.qudsiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.iug.qudsiapp.R
import com.iug.qudsiapp.databinding.ItemLocalNewsBinding
import com.iug.qudsiapp.model.local_storage.News

class LocalNewsAdapter(val onClick: (news: News) -> Unit) : RecyclerView.Adapter<LocalNewsAdapter.ViewHolder>() {

    var data = ArrayList<News>()

    inner class ViewHolder(private val binding : ItemLocalNewsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(news: News) {
            binding.news = news
            binding.cardNews.setOnClickListener {
                onClick(news)
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding : ItemLocalNewsBinding = DataBindingUtil.inflate(inflater, R.layout.item_local_news, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}