package com.iug.qudsiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.iug.qudsiapp.R
import com.iug.qudsiapp.databinding.ItemTitleBinding
import com.iug.qudsiapp.model.firestore.Title

class TitlesAdapter(val onClick: (title: Title) -> Unit) : RecyclerView.Adapter<TitlesAdapter.ViewHolder>() {

    var data = ArrayList<Title>()

    inner class ViewHolder(private val binding : ItemTitleBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(title: Title) {
            binding.title = title
            binding.cardTitle.setOnClickListener {
                onClick(title)
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding : ItemTitleBinding = DataBindingUtil.inflate(inflater, R.layout.item_title, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}