package com.team_ia.idea_archive_android.ui.main

import androidx.fragment.app.activityViewModels
import com.team_ia.domain.model.PostModel
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.PostListAdapter
import com.team_ia.idea_archive_android.databinding.FragmentMainFeedbackBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.viewmodel.MainViewModel
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.ItemDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFeedbackFragment : BaseFragment<FragmentMainFeedbackBinding>(R.layout.fragment_main_feedback) {
    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var postListAdapter: PostListAdapter

    override fun createView() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        postListAdapter = PostListAdapter(viewModel.categoryPostData.value).apply {
            setItemOnClickListener(object : PostListAdapter.OnItemClickListener {
                override fun detail(item: PostModel?) {
                    item?.postId?.let { viewModel.getDetailPost(it.toLong()) }
                }
            })
        }
        binding.rvFeedbackPost.adapter = postListAdapter
        binding.rvFeedbackPost.addItemDecoration(ItemDecorator(8))
    }

    override fun observeEvent() {
        observeCategoryPostData()
    }

    private fun observeCategoryPostData(){
        viewModel.categoryEventData.observe(this){
            when(it){
                Event.Success -> {
                    postListAdapter.submitList(viewModel.categoryPostData.value)
                }
                else -> {

                }
            }
        }
    }
}