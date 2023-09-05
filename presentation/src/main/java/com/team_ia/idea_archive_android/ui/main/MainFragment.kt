package com.team_ia.idea_archive_android.ui.main

import android.graphics.Color
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.CommentListAdapter
import com.team_ia.idea_archive_android.databinding.FragmentMainPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.viewmodel.MainViewModel
import com.team_ia.idea_archive_android.utils.Event
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainPageBinding>(R.layout.fragment_main_page) {
    private val viewModel by activityViewModels<MainViewModel>()
    private var isFabOpen = false
    private var category: Int = 0
    private val categoryFeedback: List<String> = listOf("피드백")
    private val categoryIdea: List<String> = listOf("아이디어")
    private val categoryJobOpening: List<String> = listOf("구인")



    override fun createView() {
        onClick()
    }

    private fun onClick() {
        viewModel.getPost()
        binding.fbtnMainPageFloatingButton.setOnClickListener {
            toggleFab()
        }

        binding.tvEntire.setOnClickListener {
            category = 0
            viewModel.getPost()
        }

        binding.tvJobOpening.setOnClickListener {
            category = 1
            viewModel.getCategoryPost(categoryJobOpening)
        }

        binding.tvFeedback.setOnClickListener {
            category = 2
            viewModel.getCategoryPost(categoryFeedback)

        }

        binding.tvIdea.setOnClickListener {
            category = 3
            viewModel.getCategoryPost(categoryIdea)
        }

        binding.fbtnMainPageFloatingButton.setOnClickListener {
            toggleFab()
        }
    }

    private fun toggleFab() {
        if (isFabOpen) {
            closeFabMenu()
        } else {
            openFabMenu()
        }
    }

    private fun openFabMenu() {
        binding.fbtnMainPageFloatingButton.setImageResource(R.drawable.ic_close)

        isFabOpen = true
    }

    private fun closeFabMenu() {
        binding.fbtnMainPageFloatingButton.setImageResource(R.drawable.ic_add)
        binding.fbtnWritePost.animate().translationY(0f)
        binding.fbtnWriteNotice.animate().translationY(0f)
        isFabOpen = false
    }

    override fun observeEvent() {
        observeCategoryPostData()
        observeDetailPostData()
    }

    private fun observeCategoryPostData() {
        viewModel.categoryEventData.observe(this) {
            when (it) {
                Event.Success -> {
                    when (category) {
                        0 -> {
                            binding.tvEntire.setTextColor(Color.BLACK)
                            requireActivity().findNavController(R.id.main_list_graph)
                                .popBackStack()

                        }
                        1 -> {
                            binding.tvJobOpening.setTextColor(Color.BLACK)
                            requireActivity().findNavController(R.id.main_list_graph)
                                .navigate(R.id.action_mainEntireFragment_to_mainJobOpeningFragment)
                        }
                        2 -> {
                            binding.tvFeedback.setTextColor(Color.BLACK)
                            requireActivity().findNavController(R.id.main_list_graph)
                                .navigate(R.id.action_mainEntireFragment_to_mainFeedbackFragment)
                        }
                        3 -> {
                            binding.tvIdea.setTextColor(Color.BLACK)
                            requireActivity().findNavController(R.id.main_list_graph)
                                .navigate(R.id.action_mainEntireFragment_to_mainIdeaFragment)
                        }
                    }
                }
                else -> {

                }
            }
        }
    }

    private fun observeDetailPostData() {
        viewModel.detailEventData.observe(this) {
            when (it) {
                Event.Success -> {
                    requireActivity().findNavController(R.id.fcv_fragment_main)
                        .navigate(R.id.action_mainFragment_to_detailPostFragment)
                }
                else -> {

                }
            }
        }
    }
}