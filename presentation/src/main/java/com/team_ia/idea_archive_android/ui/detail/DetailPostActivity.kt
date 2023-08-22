package com.team_ia.idea_archive_android.ui.detail

import androidx.activity.viewModels
import coil.load
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.CommentListAdapter
import com.team_ia.idea_archive_android.adapter.MajorCategoryListAdapter
import com.team_ia.idea_archive_android.databinding.ActivityDetailPostPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.viewmodel.CommentViewModel
import com.team_ia.idea_archive_android.ui.viewmodel.MainViewModel
import com.team_ia.idea_archive_android.utils.extension.setOnTextChanged
import com.team_ia.idea_archive_android.utils.formatTimeDifference
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPostActivity :
    BaseActivity<ActivityDetailPostPageBinding>(R.layout.activity_detail_post_page) {
    private val viewModel by viewModels<MainViewModel>()
    private val commentViewModel by viewModels<CommentViewModel>()
    private lateinit var commentListAdapter: CommentListAdapter
    private lateinit var majorCategoryListAdapter: MajorCategoryListAdapter

    override fun createView() {
        setDetail()
        initRecyclerView()
        postComment()
    }

    override fun observeEvent() {
    }

    private fun postComment() = binding.apply {
        etWirteComment.setOnTextChanged { _, _, _, _ ->
            ibtnSendComment.visibility
        }
        ibtnSendComment.setOnClickListener {
            val comment = etWirteComment.text.toString()
            val postId = viewModel.detailPostData.value?.postId?.toLong()
            if (postId != null) {
                commentViewModel.postComment(postId, comment)
            }
        }
    }

    private fun initRecyclerView() {
        val majorCategory =
            viewModel.detailPostData.value?.category!!.filterIndexed { index, _ -> index != 0 }
        commentListAdapter =
            viewModel.detailPostData.value?.let { CommentListAdapter(it.comment) }!!
        majorCategoryListAdapter =
            viewModel.detailPostData.value?.let { MajorCategoryListAdapter(majorCategory) }!!
        binding.rvComment.adapter = commentListAdapter
        binding.tvDetailMajor.adapter = majorCategoryListAdapter
    }

    private fun setDetail() = binding.apply {
        val viewModelDetailData = viewModel.detailPostData.value
        if (viewModelDetailData != null) {
            detailData = viewModelDetailData
            tvDetailCategory.text = "#${viewModelDetailData.category[0]}"
            ivProfileImage.load(viewModelDetailData.member.profileImage)
            tvDetailTimer.text = viewModelDetailData.createDate.formatTimeDifference()
            tvCommentCount.text = "댓글 ${viewModelDetailData.createDate} 개"
        }
    }
}
