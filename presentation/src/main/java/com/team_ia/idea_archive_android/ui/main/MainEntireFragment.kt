package com.team_ia.idea_archive_android.ui.main

import androidx.fragment.app.activityViewModels
import com.team_ia.domain.model.PostModel
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.MajorFilterListAdapter
import com.team_ia.idea_archive_android.adapter.PostListAdapter
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.viewmodel.MainViewModel
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.databinding.FragmentMainEntireBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainEntireFragment : BaseFragment<FragmentMainEntireBinding>(R.layout.fragment_main_entire) {
    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var postListAdapter: PostListAdapter
    private lateinit var majorFilterListAdapter: MajorFilterListAdapter
    private val majorFilterList = listOf(
        "FrontEnd",
        "BackEnd",
        "Android",
        "iOS",
        "Cloud",
        "GameDevelop",
        "MachineLearning",
        "Embedded",
        "DevOps",
        "DBA",
        "WebPublisher",
        "Design"
    )

    private fun initRecyclerView() {
        postListAdapter = PostListAdapter(viewModel.postData.value).apply {
            setItemOnClickListener(object : PostListAdapter.OnItemClickListener {
                override fun detail(item: PostModel?) {
                    item?.postId?.let { viewModel.getDetailPost(it.toLong()) }
                }
            })
        }
        majorFilterListAdapter = MajorFilterListAdapter(majorFilterList)
        binding.rvMajorFilter.adapter = majorFilterListAdapter
        binding.rvEntirePost.adapter = postListAdapter
    }

    override fun createView() {
        initRecyclerView()
    }

    override fun observeEvent() {
        observePostData()
    }

    private fun observePostData() {
        viewModel.eventData.observe(this) {
            when (it) {
                Event.Success -> {
                    postListAdapter.submitList(viewModel.postData.value)
                }
                else -> {

                }
            }
        }
    }


}