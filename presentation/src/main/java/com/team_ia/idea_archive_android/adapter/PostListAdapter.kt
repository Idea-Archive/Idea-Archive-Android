package com.team_ia.idea_archive_android.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.team_ia.domain.model.PostModel
import com.team_ia.idea_archive_android.databinding.FragmentMyBinding

class PostListAdapter : ListAdapter<PostModel, PostListAdapter.PostListViewHolder>(diffUtil){

    private lateinit var itemClickListener: OnItemClickListener

    class PostListViewHolder(
        val context: Context,
        val binding: FragmentMyBinding,
        val listener: OnItemClickListener
    ) :
        RecyclerView.ViewHolder(binding.root){
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PostListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<PostModel>(){
            override fun areItemsTheSame(oldItem: PostModel, newItem: PostModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: PostModel, newItem: PostModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}