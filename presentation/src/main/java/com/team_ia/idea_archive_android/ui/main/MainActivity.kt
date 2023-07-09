package com.team_ia.idea_archive_android.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityMainPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainPageBinding>(R.layout.activity_main_page) {

    val majorFilterList = listOf("FrontEnd", "BackEnd", "Android", "iOS", "Cloud", "GameDevelop", "MachineLearning", "Embedded", "DBA", "WebPublisher", "Design")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun createView() {
        TODO("Not yet implemented")
    }

    override fun observeEvent() {
        TODO("Not yet implemented")
    }

}