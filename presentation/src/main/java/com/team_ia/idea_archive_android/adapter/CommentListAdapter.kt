package com.team_ia.idea_archive_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.team_ia.domain.entity.GetDetailPostEntity
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ItemCommentBinding
import com.team_ia.idea_archive_android.utils.formatTimeDifference

class CommentListAdapter() : ListAdapter<GetDetailPostEntity.Comment, CommentListAdapter.CommentViewHolder>(diffUtil) {

    class CommentViewHolder(
        val context: Context,
        private val binding: ItemCommentBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GetDetailPostEntity.Comment) = binding.apply{
            tvCommentUserInfo.text = item.member.name + R.string.divide + item.createDate?.formatTimeDifference()
            ivCommentPorfile.load(item.member.profileImage ?:R.drawable.bg_default_profile)
            tvCommentContent.text = item.content

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder =
        CommentViewHolder(
            parent.context,
            ItemCommentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<GetDetailPostEntity.Comment>() {
            override fun areItemsTheSame(
                oldItem: GetDetailPostEntity.Comment,
                newItem: GetDetailPostEntity.Comment
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: GetDetailPostEntity.Comment,
                newItem: GetDetailPostEntity.Comment
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}