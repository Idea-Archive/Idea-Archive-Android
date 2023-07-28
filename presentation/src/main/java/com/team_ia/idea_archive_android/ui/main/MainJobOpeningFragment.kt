package com.team_ia.idea_archive_android.ui.main

import androidx.fragment.app.activityViewModels
import com.team_ia.domain.model.PostModel
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.MajorFilterListAdapter
import com.team_ia.idea_archive_android.adapter.PostListAdapter
import com.team_ia.idea_archive_android.databinding.FragmentMainJobOpeningBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.viewmodel.MainViewModel
import com.team_ia.idea_archive_android.utils.Event
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainJobOpeningFragment :
    BaseFragment<FragmentMainJobOpeningBinding>(R.layout.fragment_main_job_opening) {
    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var postListAdapter: PostListAdapter
    private lateinit var majorFilterListAdapter: MajorFilterListAdapter

    val majorFilterList = listOf(
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

    override fun createView() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        postListAdapter = PostListAdapter(viewModel.categoryPostData.value).apply {
            setItemOnClickListener(object : PostListAdapter.OnItemClickListener {
                override fun detail(item: PostModel?) {

                }
            })
        }
        majorFilterListAdapter = MajorFilterListAdapter(majorFilterList)
        binding.rvMajorFilter.adapter = majorFilterListAdapter
        binding.rvJobOpeningPost.adapter = postListAdapter
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