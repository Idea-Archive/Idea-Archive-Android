package com.team_ia.idea_archive_android.ui.main

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityMainPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainPageBinding>(R.layout.activity_main_page) {
    private val fragmentManager: FragmentManager = supportFragmentManager
    private var isFabOpen = false

    override fun createView() {
        onClick()
    }

    private fun onClick(){

        binding.fbtnMainPageFloatingButton.setOnClickListener {
            toggleFab()
        }

        binding.tvEntire.setOnClickListener {
            changeFragment(MainEntireFragment())
        }

        binding.tvJobOpening.setOnClickListener {
            changeFragment(MainJobOpeningFragment())
        }

        binding.tvFeedback.setOnClickListener {
            changeFragment(MainFeedbackFragment())
        }

        binding.tvIdea.setOnClickListener {
            changeFragment(MainIdeaFragment())
        }

        binding.fbtnMainPageFloatingButton.setOnClickListener { view ->

        }
    }
    private fun changeFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .replace(R.id.fcv_main_fragment_container, fragment)
            .commit()
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
    }

}