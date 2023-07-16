package com.team_ia.idea_archive_android.ui.main

import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.PostListAdapter
import com.team_ia.idea_archive_android.databinding.FragmentMainFeedbackBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFeedbackFragment : BaseFragment<FragmentMainFeedbackBinding>(R.layout.fragment_main_feedback) {

    private lateinit var postListAdapter: PostListAdapter

    override fun createView() {
        initRecyclerView()
    }

    fun initRecyclerView() {
        binding.rvJobOpeningPost.adapter = postListAdapter
    }

    override fun observeEvent() {
        TODO("Not yet implemented")
    }
}