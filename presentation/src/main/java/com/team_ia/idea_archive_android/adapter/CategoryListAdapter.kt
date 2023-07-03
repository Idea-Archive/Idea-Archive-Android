package com.team_ia.idea_archive_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.team_ia.domain.model.PostModel
import com.team_ia.idea_archive_android.databinding.ItemCategoryBinding

class CategoryListAdapter(private val categoryList: List<PostModel>?) : RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder>() {

    class CategoryListViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: List<String>?, position: Int){
            if (position != 0) {
                binding.tvCategory.text = data?.get(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        val limit = 3
        return categoryList?.size?.coerceAtMost(limit) ?: 3
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        holder.bind(categoryList?.get(position)?.category, position)
    }

}