package com.team_ia.idea_archive_android.ui.main

import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.Scopes
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.team_ia.idea_archive_android.BuildConfig
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityLoginPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import java.util.concurrent.FutureTask

class LoginActivity : BaseActivity<ActivityLoginPageBinding>(R.layout.activity_login_page) {

    companion object {
        private val RC_SIGN_IN: Int = 9001
    }

    private lateinit var mSignInClient: GoogleSignInClient
    override fun createView() {

        val googleClientId = BuildConfig.GOOGLE_CLIENT_ID

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestScopes(Scope(Scopes.DRIVE_APPFOLDER))
            .requestIdToken(googleClientId)
            .requestServerAuthCode(googleClientId)
            .requestEmail()
            .build()

        val loginlauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        )
        {result ->
            if (result.resultCode == Activity.RESULT_OK){
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleSignInResult(task)
            }
        }

        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.ibtnGoogleLg.setOnClickListener { view ->
            when(view.id){
                R.id.ibtn_google_lg -> loginWithGoogle()
            }
        }

        fun loginWithGoogle() {
            val signInIntent: Intent = mGoogleSignInClient.signInIntent
            loginlauncher.launch(signInIntent)
        }

        private fun handleSignInResult(completedTask: FutureTask<GoogleSignInAccount>){
            try {
                val authCode = completedTask.getResult(ApiException::class.java)?.serverAuthCode

                mainScope {
                    authCode?.run {

                    }

                    }
                }
            }
        }
    }
}