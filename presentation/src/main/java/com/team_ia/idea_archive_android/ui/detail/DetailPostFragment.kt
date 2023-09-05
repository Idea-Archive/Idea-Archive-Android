package com.team_ia.idea_archive_android.ui.detail

import android.os.Build
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import coil.load
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.CommentListAdapter
import com.team_ia.idea_archive_android.adapter.MajorCategoryListAdapter
import com.team_ia.idea_archive_android.databinding.FragmentDetailPostPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.viewmodel.CommentViewModel
import com.team_ia.idea_archive_android.ui.viewmodel.MainViewModel
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.extension.setOnTextChanged
import com.team_ia.idea_archive_android.utils.formatTimeDifference
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail_post_page.*

@AndroidEntryPoint
class DetailPostFragment: BaseFragment<FragmentDetailPostPageBinding>(R.layout.fragment_detail_post_page) {
    private val viewModel by activityViewModels<MainViewModel>()
    private val commentViewModel by viewModels<CommentViewModel>()
    private lateinit var commentListAdapter: CommentListAdapter
    private lateinit var majorCategoryListAdapter: MajorCategoryListAdapter

    override fun createView() {
        setDetail()
        initRecyclerView()
        postComment()
        onClick()
    }

    override fun observeEvent() {
        observePostComment()
    }

    private fun postComment() = binding.apply {
        etWirteComment.setOnTextChanged { _, _, _, _ ->
            ibtnSendComment.visibility = View.VISIBLE
        }
        ibtnSendComment.setOnClickListener {
            val comment = etWirteComment.text.toString()
            val postId = viewModel.detailPostData.value?.postId?.toLong()
            if (postId != null) {
                commentViewModel.postComment(postId, comment)
            }
        }
    }
    private fun onClick() = binding.apply{
        ibtnBackButton.setOnClickListener {
            requireActivity().findNavController(R.id.fcv_fragment_main)
                .navigate(R.id.action_detailPostFragment_to_mainFragment)
        }
        ibtnHeart.setOnClickListener {
            viewModel.detailPostData.value?.let { it1 -> viewModel.heartPost(it1.postId) }
        }
    }

    private fun initRecyclerView() {
        commentListAdapter = CommentListAdapter()
        majorCategoryListAdapter = MajorCategoryListAdapter()
        binding.rvComment.adapter = commentListAdapter
        binding.tvDetailMajor.adapter = majorCategoryListAdapter

        majorCategoryListAdapter.submitList(viewModel.detailPostData.value?.category?.filterIndexed { index, _ -> index != 0  })
        commentListAdapter.submitList(viewModel.detailPostData.value?.comment)
    }

    private fun setDetail(){
        val viewModelDetailData = viewModel.detailPostData.value
        if (viewModelDetailData != null) {
            binding.detailData = viewModelDetailData
            binding.tvDetailCategory.text = "#${viewModelDetailData.category[0]}"
            binding.ivProfileImage.load(viewModelDetailData.member.profileImage)
            binding.tvDetailTimer.text = viewModelDetailData.createDate?.formatTimeDifference()
            binding.tvCommentCount.text = "댓글 ${viewModelDetailData.createDate} 개"
            binding.tvHeartCount.text = viewModelDetailData.heartCount.toString()
        }
    }

    private fun observePostComment(){
        commentViewModel.eventFlow.observe(this){
            when(it){
                Event.Success -> {
                    initRecyclerView()
                }
                else -> {

                }
            }
        }
    }
}