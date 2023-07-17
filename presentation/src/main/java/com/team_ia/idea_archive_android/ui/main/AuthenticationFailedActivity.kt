package com.team_ia.idea_archive_android.ui.main

import android.content.Intent
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityAuthenticationFailedPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticationFailedActivity: BaseActivity<ActivityAuthenticationFailedPageBinding>(R.layout.activity_authentication_failed_page){
    override fun createView() {
        binding.btnGoBackToLoginPage.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }

    override fun observeEvent() {
    }

}