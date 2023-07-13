package com.team_ia.idea_archive_android.ui.main

import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.MajorFilterListAdapter
import com.team_ia.idea_archive_android.databinding.FragmentMainEntireBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment

class MainEntireFragment : BaseFragment<FragmentMainEntireBinding>(R.layout.fragment_main_entire) {

    private lateinit var majorFilterListAdapter: MajorFilterListAdapter
    val majorFilterList = listOf("FrontEnd", "BackEnd", "Android", "iOS", "Cloud", "GameDevelop", "MachineLearning", "Embedded","DevOps", "DBA", "WebPublisher", "Design")

    fun initRecyclerView(){
        majorFilterListAdapter = MajorFilterListAdapter(majorFilterList)
    }

    override fun createView() {
        initRecyclerView()
        binding
    }

    override fun observeEvent() {
        TODO("Not yet implemented")
    }


}