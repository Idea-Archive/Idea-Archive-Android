package com.team_ia.idea_archive_android.ui.main

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityMainPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import dagger.hilt.android.qualifiers.ApplicationContext

class MainActivity : BaseActivity<ActivityMainPageBinding>(R.layout.activity_main_page) {

    val fragmentManager: FragmentManager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val entirePost = findViewById<TextView>(R.id.tv_entire)

        entirePost.setOnClickListener {
            showEntirePostFragment()
        }
    }


    private fun showEntirePostFragment() {
        fragmentManager.beginTransaction()
            .replace(R.id.fcv_main_entire_fragment_container, MainEntireFragment())
    }

    override fun createView() {
    }

    override fun observeEvent() {
    }

}