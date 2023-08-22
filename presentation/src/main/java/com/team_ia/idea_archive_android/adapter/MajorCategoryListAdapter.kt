package com.team_ia.idea_archive_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.team_ia.domain.entity.GetDetailPostEntity
import com.team_ia.idea_archive_android.databinding.ItemCategoryBinding

class MajorCategoryListAdapter(private val categoryList: List<String>) :
    ListAdapter<GetDetailPostEntity, MajorCategoryListAdapter.MajorCategoryViewHolder>(diffUtil) {
    class MajorCategoryViewHolder(
        val context: Context,
        private val binding: ItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) = binding.apply {
            tvCategory.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MajorCategoryViewHolder =
        MajorCategoryViewHolder(
            parent.context,
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(
        holder: MajorCategoryListAdapter.MajorCategoryViewHolder,
        position: Int
    ) {
        holder.bind(categoryList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<GetDetailPostEntity>() {
            override fun areItemsTheSame(
                oldItem: GetDetailPostEntity,
                newItem: GetDetailPostEntity
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: GetDetailPostEntity,
                newItem: GetDetailPostEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}