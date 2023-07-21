package com.team_ia.idea_archive_android.ui.main

import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.PostListAdapter
import com.team_ia.idea_archive_android.databinding.FragmentMainIdeaBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainIdeaFragment : BaseFragment<FragmentMainIdeaBinding>(R.layout.fragment_main_idea) {

    private lateinit var postListAdapter: PostListAdapter

    override fun createView() {
        initRecyclerView()
    }

    fun initRecyclerView() {
        binding.rvIdeaPost.adapter = postListAdapter
    }

    override fun observeEvent() {
        TODO("Not yet implemented")
    }

}