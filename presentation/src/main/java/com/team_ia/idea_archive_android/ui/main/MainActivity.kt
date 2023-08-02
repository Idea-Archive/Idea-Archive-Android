package com.team_ia.idea_archive_android.ui.main

import android.content.Intent
import androidx.drawerlayout.widget.DrawerLayout
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
    private var category:Int = 0
    private val categoryFeedback: List<String> = listOf("피드백")
    private val categoryIdea: List<String> = listOf("아이디어")
    private val categoryJobOpening: List<String> = listOf("구인")

    override fun createView() {
        onClick()
    }

    private fun onClick(){
        viewModel.getPost()
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

        binding.fbtnMainPageFloatingButton.setOnClickListener { view ->

        }

        binding.btnMainPageMenuBarButton.setOnClickListener {
            binding.mainPageDrawerLayout.open()
        }

        setUpViews()
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

    private fun setUpViews() {
        drawerLayout = binding.mainPageDrawerLayout
        navigationView = binding.nvMainNavigation

        binding.btnMainPageMenuBarButton.setOnClickListener {
            drawerLayout.openDrawer(navigationView)
        }
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
//                R.id.item_notice -> {
//                      // 공지부분 퍼블리싱 후 연결
//                }

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
            drawerLayout.closeDrawer(navigationView)
            true
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView)
        } else {
            super.getOnBackPressedDispatcher()
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

    private fun observeCategoryPostData(){
        viewModel.categoryEventData.observe(this){
            when(it){
                Event.Success -> {
                    when(category){
                        1 ->{
                            changeFragment(MainJobOpeningFragment())
                        }
                        2 ->{
                            changeFragment(MainFeedbackFragment())
                        }
                        3 ->{
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