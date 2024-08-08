package com.vik.assignmentandroiduae.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vik.assignmentandroiduae.databinding.ItemUniversityBinding
import com.vik.assignmentandroiduae.domain.model.University

class UniversityAdapter(
    private val onItemClick: (University?) -> Unit
) : ListAdapter<University, UniversityAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUniversityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemUniversityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(university: University?) {
            binding.titleTextView.text = university?.name
            binding.descriptionTextView.text = university?.country
            binding.arrowImageView.setOnClickListener {
                onItemClick(university)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<University>() {
            override fun areItemsTheSame(oldItem: University, newItem: University): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: University, newItem: University): Boolean {
                return oldItem == newItem
            }
        }
    }
}
