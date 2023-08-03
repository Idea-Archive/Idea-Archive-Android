package com.team_ia.idea_archive_android.ui.main

import android.content.Intent
import androidx.drawerlayout.widget.DrawerLayout
import android.animation.ObjectAnimator
import android.view.Gravity
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityMainPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.profile.ProfileActivity
import com.team_ia.idea_archive_android.ui.viewmodel.MainViewModel
import com.team_ia.idea_archive_android.utils.Event
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainPageBinding>(R.layout.activity_main_page) {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private val fragmentManager: FragmentManager = supportFragmentManager
    private val viewModel by viewModels<MainViewModel>()
    private var isFabOpen = false
    private var category: Int = 0
    private val categoryFeedback: List<String> = listOf("피드백")
    private val categoryIdea: List<String> = listOf("아이디어")
    private val categoryJobOpening: List<String> = listOf("구인")

    override fun createView() {
        onClick()
    }

    private fun onClick() {
        setUpViews()
        viewModel.getPost()
        drawerLayout = binding.mainPageDrawerLayout
        binding.fbtnMainPageFloatingButton.bringToFront()
        binding.fbtnMainPageFloatingButton.setOnClickListener {
            toggleFab()
        }

        binding.tvEntire.setOnClickListener {
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

        binding.btnMainPageMenuBarButton.setOnClickListener {
            drawerLayout.openDrawer(Gravity.RIGHT)
            if (drawerLayout.isDrawerOpen(Gravity.RIGHT)){
                drawerLayout.closeDrawer(Gravity.RIGHT)
            }
        }

        binding.fbtnWritePost.setOnClickListener {
            //글쓰기 페이지로 인텐트 시키기
        }

//        binding.fbtnWriteNotice.setOnClickListener {
//            // "admin"권한일때만 공지 페이지로 인텐트 시키기
//        }
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
        ObjectAnimator.ofFloat(binding.fbtnMainPageFloatingButton, View.ROTATION, 0f, 45f)
            .apply { start() }
        ObjectAnimator.ofFloat(binding.fbtnWritePost, "translationY", -180f).apply { start() }
        binding.tvWritePostBubble.elevation = 1f
        ObjectAnimator.ofFloat(binding.tvWritePostBubble, "translationY", -180f).apply { start() }
        isFabOpen = true
    }

    private fun closeFabMenu() {
        ObjectAnimator.ofFloat(binding.fbtnMainPageFloatingButton, View.ROTATION, 0f)
            .apply { start() }
        ObjectAnimator.ofFloat(binding.fbtnWritePost, "translationY", 0f).apply { start() }
        ObjectAnimator.ofFloat(binding.tvWritePostBubble, "translationY", 0f).apply { start() }
        binding.tvWritePostBubble.elevation = 0f
        isFabOpen = false
    }

    private fun setUpViews() {
        drawerLayout = binding.mainPageDrawerLayout
        navigationView = binding.nvMainNavigation

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_view_my_post -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.item_view_like_post -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }

//                R.id.item_logout -> {
//                   // 대진님 여기다가 로그아웃 작업 하시면 됩니다.
//                }
            }
            true
        }
    }

    override fun observeEvent() {
        observePostData()
        observeCategoryPostData()
    }

    private fun observePostData() {
        viewModel.eventData.observe(this) {
            when (it) {
                Event.Success -> {
                    changeFragment(MainEntireFragment())
                }

                else -> {

                }
            }
        }
    }

    private fun observeCategoryPostData() {
        viewModel.categoryEventData.observe(this) {
            when (it) {
                Event.Success -> {
                    when (category) {
                        1 -> {
                            changeFragment(MainJobOpeningFragment())
                        }

                        2 -> {
                            changeFragment(MainFeedbackFragment())
                        }

                        3 -> {
                            changeFragment(MainIdeaFragment())
                        }
                    }
                }

                else -> {

                }
            }
        }
    }

}