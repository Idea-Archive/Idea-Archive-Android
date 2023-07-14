package com.team_ia.idea_archive_android.ui.main


import android.util.Log
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivitySignUpPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : BaseActivity<ActivitySignUpPageBinding>(R.layout.activity_sign_up_page) {
    override fun createView() {
        Log.d("엑티비티 실행", "실행은 되는 것")
    }

    override fun observeEvent() {}
}