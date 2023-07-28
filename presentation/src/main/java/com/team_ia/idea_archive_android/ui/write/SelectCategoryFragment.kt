package com.team_ia.idea_archive_android.ui.write

import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.FragmentSelectCategoryBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.viewmodel.WriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectCategoryFragment : BaseFragment<FragmentSelectCategoryBinding>(R.layout.fragment_select_category) {
    private val writeViewModel by activityViewModels<WriteViewModel>()

    override fun createView() {
        onClick()
    }

    companion object {
        val blank = ""
        val idea = "아이디어"
        val feedback = "피드백"
        val jobopening = "구인"
    }

    private var categoryList = blank
    private var selectedCategoryList: MutableList<String> = mutableListOf()

    private fun onClick() = binding.apply {
        btnIdeaButton.setOnClickListener {
            when (categoryList) {
                blank, feedback, jobopening -> {
                    setIdeaBtn()
                }
            }
        }
        btnFeedbackButton.setOnClickListener {
            when (categoryList) {
                blank, idea, jobopening -> {
                    setFeedbackBtn()
                }
            }
        }
        btnJobopeningButton.setOnClickListener {
            when (categoryList) {
                blank, idea, feedback -> {
                    setJobopeningBtn()
                }
            }
        }
        btnNextButton.setOnClickListener {
            when (categoryList) {
                idea, feedback -> {
                    writeViewModel.setCategoryList(selectedCategoryList)
                    requireActivity().findNavController(R.id.write_container)
                        .navigate(R.id.action_selectCategoryFragment_to_writeFragment)
                }
                jobopening ->{
                    requireActivity().findNavController(R.id.write_container)
                        .navigate(R.id.action_selectCategoryFragment_to_selectMajorFragment)
                }
            }
        }

    }

    override fun observeEvent() {

    }

    private fun setIdeaBtn() = binding.apply {
        btnIdeaButton.setBackgroundResource(R.drawable.bg_idea_btn)
        categoryList = idea
        selectedCategoryList.add("아이디어")
        selectedCategoryList.remove("피드백")
        btnFeedbackButton.setBackgroundResource(R.drawable.bg_feedback_false_btn)
        btnJobopeningButton.setBackgroundResource(R.drawable.bg_jobopening_false_btn)
    }

    private fun setFeedbackBtn() = binding.apply {
        btnFeedbackButton.setBackgroundResource(R.drawable.bg_feedback_btn)
        categoryList = feedback
        selectedCategoryList.add("피드백")
        selectedCategoryList.remove("아이디어")
        btnIdeaButton.setBackgroundResource(R.drawable.bg_idea_false_btn)
        btnJobopeningButton.setBackgroundResource(R.drawable.bg_jobopening_false_btn)
    }

    private fun setJobopeningBtn() = binding.apply {
        btnJobopeningButton.setBackgroundResource(R.drawable.bg_jobopening_btn)
        categoryList = jobopening
        selectedCategoryList.removeAll(selectedCategoryList)
        btnIdeaButton.setBackgroundResource(R.drawable.bg_idea_false_btn)
        btnFeedbackButton.setBackgroundResource(R.drawable.bg_feedback_false_btn)
    }
}