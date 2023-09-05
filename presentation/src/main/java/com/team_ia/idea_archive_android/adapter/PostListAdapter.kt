package com.team_ia.idea_archive_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.team_ia.domain.model.PostModel
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ItemPostBinding
import com.team_ia.idea_archive_android.utils.formatTimeDifference

class PostListAdapter() : ListAdapter<PostModel, PostListAdapter.PostListViewHolder>(diffUtil) {

    private lateinit var itemClickListener: OnItemClickListener

    class PostListViewHolder(
        val context: Context,
        private val binding: ItemPostBinding,
        val listener: OnItemClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PostModel?) = binding.apply {
            tvInformation.text =
                item?.member?.name + R.string.divide + item?.createDate?.formatTimeDifference()
            tvContent.text = item?.title
            ivProfile.load(item?.member?.profileImage ?: R.drawable.bg_default_profile)
            if (item?.commentCount!! > 99) {
                tvCommentCount.text = "99+"
            } else {
                tvCommentCount.text = item.commentCount.toString()
            }
            if (item?.heartCount!! > 99) {
                tvHeartCount.text = "99+"
            } else {
                tvHeartCount.text = item.heartCount.toString()
            }
            postItemLayout.setOnClickListener {
                listener.detail(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListViewHolder =
        PostListViewHolder(
            parent.context,
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            itemClickListener
        )

    override fun onBindViewHolder(holder: PostListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface OnItemClickListener {
        fun detail(item: PostModel?)
    }

    fun setItemOnClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<PostModel>() {
            override fun areItemsTheSame(oldItem: PostModel, newItem: PostModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: PostModel, newItem: PostModel): Boolean {
                return oldItem == newItem
            }
        }
    }

}