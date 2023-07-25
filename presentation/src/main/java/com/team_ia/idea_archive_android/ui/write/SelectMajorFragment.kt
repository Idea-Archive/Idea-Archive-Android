package com.team_ia.idea_archive_android.ui.write

import androidx.fragment.app.activityViewModels
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.FragmentSelectMajorBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.viewmodel.WriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectMajorFragment : BaseFragment<FragmentSelectMajorBinding>(R.layout.fragment_select_major) {
    private val writeViewModel by activityViewModels<WriteViewModel>()
    override fun createView() {

    }

    override fun observeEvent() {

    }
}