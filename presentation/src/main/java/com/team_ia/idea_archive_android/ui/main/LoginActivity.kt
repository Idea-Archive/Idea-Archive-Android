package com.team_ia.idea_archive_android.ui.main

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.team_ia.idea_archive_android.BuildConfig
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityLoginPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginPageBinding>(R.layout.activity_login_page) {

    companion object {
        private val RC_SIGN_IN: Int = 9001
    }

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var loginLauncher: ActivityResultLauncher<Intent>


    override fun createView() {

        val googleClientId = BuildConfig.GOOGLE_CLIENT_ID
        val githubClientId = BuildConfig.GITHUB_CLIENT_ID

        val googleSocialLogin = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestServerAuthCode(googleClientId)
            .requestEmail()
            .build()
        val client = GoogleSignIn.getClient(this, googleSocialLogin)

        loginLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            }
        }

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }

        googleSignInClient = GoogleSignIn.getClient(this, googleSocialLogin)

        binding.ibtnGoogleLg.setOnClickListener { view ->
            loginLauncher.launch(client.signInIntent)
        }

        val githubSignInClient = Intent(
            Intent.ACTION_VIEW, Uri.parse(
                "https://github.com/login/oauth/authorize?client_id=$githubClientId"
            )
        )


        binding.ibtnGithubLg.setOnClickListener { view ->
            launcher.launch(githubSignInClient)
        }

    }

    override fun onResume() {
        super.onResume()
        println("code ${intent?.data?.getQueryParameter("code")}")
    }
}