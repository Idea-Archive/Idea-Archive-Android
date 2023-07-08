package com.team_ia.idea_archive_android.ui.main

import androidx.activity.viewModels
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivitySignUpPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.viewmodel.SignupViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : BaseActivity<ActivitySignUpPageBinding>(R.layout.activity_sign_up_page) {
    private val signupViewModel by viewModels<SignupViewModel>()
    override fun createView() {

    }

    override fun observeEvent() {
        TODO("Not yet implemented")
    }


}