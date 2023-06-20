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
            println("인가코드 ${result}")
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                println("인가코드 ${task.result?.serverAuthCode}")
            }
        }

        googleSignInClient = GoogleSignIn.getClient(this, googleSocialLogin)

        binding.ibtnGoogleLg.setOnClickListener { view ->
            loginLauncher.launch(client.signInIntent)
        }

        val githubSocialLogin = Uri.Builder().scheme("https").authority("github.com")
            .appendPath("login")
            .appendPath("oauth")
            .appendPath("authorize")
            .appendQueryParameter("client_id", githubClientId)
            .build()

        val githubSignInClient = Intent(Intent.ACTION_VIEW, githubSocialLogin)


        binding.ibtnGithubLg.setOnClickListener { view ->
            startActivity(githubSignInClient)
        }

    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.data?.getQueryParameter("code")
    }

}