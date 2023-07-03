package com.team_ia.idea_archive_android.ui.profile

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.viewpager.MyViewPagerAdapter
import com.team_ia.idea_archive_android.databinding.ActivityProfileBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity

class ProfileActivity : BaseActivity<ActivityProfileBinding>(R.layout.activity_profile) {

    private val myViewPagerAdapter by lazy { MyViewPagerAdapter(this) }
    override fun createView() {
        initViewPager()
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
            }
        })


    }

}