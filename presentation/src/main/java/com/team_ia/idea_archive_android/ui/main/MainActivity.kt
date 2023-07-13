package com.team_ia.idea_archive_android.ui.main

import android.os.Bundle
import android.widget.TextView
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityMainPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainPageBinding>(R.layout.activity_main_page) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val entirePost = findViewById<TextView>(R.id.tv_entire)
        entirePost.setOnClickListener {
            val entirePostFragment = MainEntireFragment()
        }
    }

    override fun createView() {
    }

    override fun observeEvent() {
    }

}