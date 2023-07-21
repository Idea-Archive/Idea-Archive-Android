package com.team_ia.idea_archive_android.ui.main

import android.content.Intent
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityAuthenticationSuccessPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.login.LoginActivity



class AuthenticationSuccessActivity : BaseActivity<ActivityAuthenticationSuccessPageBinding> (R.layout.activity_authentication_success_page) {
    override fun createView() {
        binding.btnGoBackToLoginPage.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    override fun observeEvent() {

    }

}