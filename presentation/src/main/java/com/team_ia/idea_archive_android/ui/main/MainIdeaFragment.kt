package com.team_ia.idea_archive_android.ui.main

import androidx.fragment.app.activityViewModels
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.PostListAdapter
import com.team_ia.idea_archive_android.databinding.FragmentMainIdeaBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainIdeaFragment : BaseFragment<FragmentMainIdeaBinding>(R.layout.fragment_main_idea) {
    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var postListAdapter: PostListAdapter

    override fun createView() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        postListAdapter = PostListAdapter(viewModel.categoryPostData.value)
        binding.rvIdeaPost.adapter = postListAdapter
    }

    override fun observeEvent() {
    }

}