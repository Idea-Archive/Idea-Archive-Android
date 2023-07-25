package com.team_ia.idea_archive_android.ui.write

import androidx.fragment.app.activityViewModels
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.FragmentWritePageBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.viewmodel.WriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WriteFragment : BaseFragment<FragmentWritePageBinding>(R.layout.fragment_write_page) {
    private val writeViewModel by activityViewModels<WriteViewModel>()
    override fun createView() {

    }

    override fun observeEvent() {

    }

}