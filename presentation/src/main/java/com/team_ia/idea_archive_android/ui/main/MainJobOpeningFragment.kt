package com.team_ia.idea_archive_android.ui.main

import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.MajorFilterListAdapter
import com.team_ia.idea_archive_android.adapter.PostListAdapter
import com.team_ia.idea_archive_android.databinding.FragmentMainJobOpeningBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainJobOpeningFragment : BaseFragment<FragmentMainJobOpeningBinding>(R.layout.fragment_main_job_opening) {

    private lateinit var postListAdapter: PostListAdapter
    private lateinit var majorFilterListAdapter: MajorFilterListAdapter

    val majorFilterList = listOf("FrontEnd", "BackEnd", "Android", "iOS", "Cloud", "GameDevelop", "MachineLearning", "Embedded","DevOps", "DBA", "WebPublisher", "Design")

    override fun createView() {
        initRecyclerView()
    }

    fun initRecyclerView() {
        majorFilterListAdapter = MajorFilterListAdapter(majorFilterList)
        binding.rvMajorFilter.adapter = majorFilterListAdapter
    }
    override fun observeEvent() {
        TODO("Not yet implemented")
    }

}