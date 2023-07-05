package com.team_ia.idea_archive_android.ui.profile

import androidx.fragment.app.viewModels
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.PostListAdapter
import com.team_ia.idea_archive_android.databinding.FragmentLikedBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.viewmodel.MyViewModel
import com.team_ia.idea_archive_android.utils.ItemDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikedFragment : BaseFragment<FragmentLikedBinding>(R.layout.fragment_liked) {
    private val viewModel by viewModels<MyViewModel>()
    private lateinit var adapter: PostListAdapter
    override fun createView() {
        initRecyclerView()
    }

    override fun observeEvent() {
    }

    private fun initRecyclerView() {
        adapter = PostListAdapter(viewModel.postData.value)
        binding.rvLiked.addItemDecoration(ItemDecorator(8))
        binding.rvLiked.adapter = adapter
    }

}