package com.team_ia.idea_archive_android.ui.main

import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.Scopes
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityLoginPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import javax.inject.Scope

class LoginActivity : BaseActivity<ActivityLoginPageBinding>(R.layout.activity_login_page) {

    companion object {
        private val RC_SIGN_IN: Int = 9001
    }

    private lateinit var mSignInClient: GoogleSignInClient
    override fun createView() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestScopes(Scope(Scopes.DRIVE_APPFOLDER))
            .requestIdToken(googleClientId)
            .requestServerAuthCode(googleClientId)
            .requestEmail()
            .build()
    }
}