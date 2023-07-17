package com.team_ia.idea_archive_android.ui.profile

import android.content.Intent
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.google.android.material.tabs.TabLayoutMediator
import com.team_ia.domain.entity.MemberEntity
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.viewpager.MyViewPagerAdapter
import com.team_ia.idea_archive_android.databinding.ActivityProfileBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.main.LoginActivity
import com.team_ia.idea_archive_android.ui.viewmodel.MyViewModel
import com.team_ia.idea_archive_android.utils.Event
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : BaseActivity<ActivityProfileBinding>(R.layout.activity_profile) {
    private val myViewPagerAdapter by lazy { MyViewPagerAdapter(this) }
    private val myViewModel by viewModels<MyViewModel>()
    private var profile: MemberEntity? = null
    override fun createView() {
        binding.goTo = this
        initViewPager()
        myViewModel.getProfile()
        backButtonPressed()
    }



    override fun observeEvent() {
        observeProfileInfo()
        observeEditProfile()
        observePostInfo()
    }

    private fun initViewPager() {
        val likedPost: String = resources.getString(R.string.liked_post)
        val myPost: String = resources.getString(R.string.my_post)
        val tabTextList = listOf(likedPost, myPost)
        myViewPagerAdapter.addFragment(LikedFragment())
        myViewPagerAdapter.addFragment(MyFragment())

        binding.viewPager.adapter = myViewPagerAdapter

        TabLayoutMediator(binding.tabProfile, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = tabTextList[position]
                1 -> tab.text = tabTextList[position]
            }
        }.attach()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                observePostInfo()
                myViewModel.getPost(position)
            }
        })
    }

    private fun myProfile() {
            profile = myViewModel.profileData.value
            binding.apply {
                tvName.text = myViewModel.profileData.value?.name
                ivProfile.load(myViewModel.profileData.value?.profileImg ?: R.drawable.bg_default_profile)
            }
    }

    private fun observeProfileInfo() {
        myViewModel.getProfileInfo.observe(this) {
            when (it) {
                Event.Success -> {
                    myProfile()
                }
                Event.Unauthorized -> {
                    longToast("토큰이 만료되었습니다, 로그아웃 이후 다시 로그인해주세요.").let {
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
                Event.NotFound -> {
                    shortToast("사용자를 찾을 수 없습니다.")
                }
                Event.UnKnown -> {
                    shortToast("알 수 없는 오류가 발생했습니다.")
                }
                else -> {
                    shortToast("기타 오류 발생.")
                }
            }
        }
    }

    private fun observeEditProfile() {
        myViewModel.editProfileInfo.observe(this) {
            when (it) {
                Event.Success -> {
                    myViewModel.getProfile()
                }
                Event.Unauthorized -> {
                    longToast("토큰이 만료되었습니다, 로그아웃 이후 다시 로그인해주세요.").let {
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
                Event.NotFound -> {
                    shortToast("알 수 없는 오류가 발생했습니다.")
                }
                else -> {
                    shortToast("기타 오류 발생.")
                }
            }
        }
    }

    private fun observePostInfo() {
        myViewModel.getPostInfo.observe(this) {
            when (it) {
                Event.Success -> {
                }
                Event.Unauthorized -> {
                    longToast("토큰이 만료되었습니다, 로그아웃 이후 다시 로그인해주세요.").let {
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
                Event.NotFound -> {
                    shortToast("글이 없습니다")
                }
               else -> {
                    shortToast("기타 오류 발생.")
                }
            }
        }
    }

    private fun backButtonPressed() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        }
        this.onBackPressedDispatcher.addCallback(callback)
    }

    fun onClickPageButton(view: View) {
        when (view) {
            binding.btnDetail, binding.tvName ->
                startActivity(Intent(this, EditProfileActivity::class.java).putExtra("profile", profile))
            binding.ibtnBackButton ->
                finish()
        }
    }

}