package com.iug.qudsiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.iug.qudsiapp.R
import com.iug.qudsiapp.databinding.ItemSubjectBinding
import com.iug.qudsiapp.model.firestore.Subject

class SubjectsAdapter(val onClick: (subject: Subject) -> Unit) : RecyclerView.Adapter<SubjectsAdapter.ViewHolder>() {

    var data = ArrayList<Subject>()

    inner class ViewHolder(private val binding : ItemSubjectBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(subject: Subject) {
            binding.subject = subject
            binding.cardSubject.setOnClickListener {
                onClick(subject)
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding : ItemSubjectBinding = DataBindingUtil.inflate(inflater, R.layout.item_subject, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}