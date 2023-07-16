package com.team_ia.idea_archive_android.ui.main

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityMainPageBinding
import com.team_ia.idea_archive_android.databinding.FragmentMainEntireBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainPageBinding>(R.layout.activity_main_page) {

    val fragmentManager: FragmentManager = supportFragmentManager

    override fun createView() {

        binding.tvEntire.setOnClickListener {
            showEntirePostFragment()
        }

        binding.tvJobOpening.setOnClickListener {
            showJobOpeningPostFragment()
        }
    }

    private fun showJobOpeningPostFragment() {
        fragmentManager.beginTransaction()
            .replace(R.id.fcv_main_job_opening_fragment_container, MainJobOpeningFragment())
            .commit()
    }

    private fun showEntirePostFragment() {
        fragmentManager.beginTransaction()
            .replace(R.id.fcv_main_entire_fragment_container, MainEntireFragment()).commit()
    }

    override fun observeEvent() {
    }

}