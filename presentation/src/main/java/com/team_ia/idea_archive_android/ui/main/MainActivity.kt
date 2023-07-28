package com.team_ia.idea_archive_android.ui.main

import android.animation.ObjectAnimator
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityMainPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainPageBinding>(R.layout.activity_main_page) {

    val fragmentManager: FragmentManager = supportFragmentManager
    private var isFabOpen = false

    override fun createView() {
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

        binding.fbtnMainPageFloatingButton.setOnClickListener {
            toggleFab()
        }

        binding.fbtnWritePost.setOnClickListener {
            //글쓰기 페이지로 인텐트 시키기
        }

        binding.fbtnWriteNotice.setOnClickListener {
            // "admin"권한일때만 공지 페이지로 인텐트 시키기
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
        ObjectAnimator.ofFloat(binding.fbtnMainPageFloatingButton, View.ROTATION, 0f, 45f).apply { start() }
        ObjectAnimator.ofFloat(binding.fbtnWritePost, "translationY", -360f).apply { start() }
        ObjectAnimator.ofFloat(binding.fbtnWriteNotice, "translationY", -180f).apply { start() }
        isFabOpen = true
    }

    private fun closeFabMenu() {
        ObjectAnimator.ofFloat(binding.fbtnMainPageFloatingButton, View.ROTATION, 0f, 45f).apply { start() }
        ObjectAnimator.ofFloat(binding.fbtnWritePost, "translationY", 0f).apply { start() }
        ObjectAnimator.ofFloat(binding.fbtnWriteNotice, "translationY", 0f).apply { start() }
        isFabOpen = false
    }

    override fun observeEvent() {
    }

}