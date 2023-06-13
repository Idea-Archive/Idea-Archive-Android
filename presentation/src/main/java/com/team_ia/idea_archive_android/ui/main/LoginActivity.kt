package com.team_ia.idea_archive_android.ui.main

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.Scopes
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.google.android.gms.tasks.Task
import com.team_ia.idea_archive_android.BuildConfig
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityLoginPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginPageBinding>(R.layout.activity_login_page) {

    companion object {
        private val RC_SIGN_IN: Int = 9001
    }

    private lateinit var mSignInClient: GoogleSignInClient
    private lateinit var loginLauncher: ActivityResultLauncher<Intent>
    override fun createView() {

        val googleClientId = BuildConfig.GOOGLE_CLIENT_ID

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestScopes(Scope(Scopes.DRIVE_APPFOLDER))
            .requestIdToken(googleClientId)
            .requestServerAuthCode(googleClientId)
            .requestEmail()
            .build()

        loginLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        )
        { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleSignInResult(task)
            }
        }

        mSignInClient = GoogleSignIn.getClient(this, gso)

        binding.ibtnGoogleLg.setOnClickListener { view ->
            when (view.id) {
                R.id.ibtn_google_lg -> loginWithGoogle()
            }
        }

    }

    fun loginWithGoogle() {
        val signInIntent: Intent = mSignInClient.signInIntent
        loginLauncher.launch(signInIntent)
    }


    fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        kotlin.runCatching {
            completedTask.getResult(ApiException::class.java)?.serverAuthCode
        }.onSuccess {
            println("authCode $it")
        }
    }

}