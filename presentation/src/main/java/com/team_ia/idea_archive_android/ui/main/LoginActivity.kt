package com.team_ia.idea_archive_android.ui.main

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.team_ia.idea_archive_android.BuildConfig
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityLoginPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.viewmodel.KakaoSocialLoginViewModel
import com.team_ia.idea_archive_android.ui.viewmodel.LoginViewModel
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.extension.changeAtivatedWithEnabled
import com.team_ia.idea_archive_android.utils.extension.repeatOnStart
import com.team_ia.idea_archive_android.utils.extension.setOnTextChanged
import com.team_ia.idea_archive_android.utils.keyBoardHide

class LoginActivity : BaseActivity<ActivityLoginPageBinding>(R.layout.activity_login_page) {
    private val loginViewModel by viewModels<LoginViewModel>()
    private val kakaoLoginViewModel by viewModels<KakaoSocialLoginViewModel>()
    companion object {
        private val RC_SIGN_IN: Int = 9001
    }

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var loginLauncher: ActivityResultLauncher<Intent>

    override fun createView() {
        binding.login = this
        initView()
        repeatOnStart {
            loginViewModel.eventFlow.collect { event -> handleEvent(event as Event.Success) }
        }
        repeatOnStart {
            loginViewModel.eventFlow.collect { event -> errorHandleEvent(event as Event.NotFound) }
        }

        val kakaoNativeAppKey = BuildConfig.KAKAO_NATIVE_APP_KEY
        val googleClientId = BuildConfig.GOOGLE_CLIENT_ID
        val githubClientId = BuildConfig.GITHUB_CLIENT_ID

        KakaoSdk.init(this, kakaoNativeAppKey)

        val googleSocialLogin = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestServerAuthCode(googleClientId)
            .requestEmail()
            .build()

        val client = GoogleSignIn.getClient(this, googleSocialLogin)

        loginLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                println("인가코드 ${result}")
                if (result.resultCode == RESULT_OK) {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                }
            }

            val launcher =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

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
                startActivity(githubSignInClient)
            }

            binding.ibtnKakaoLg.setOnClickListener { view ->
                kakaoLoginViewModel.kakaoLogin()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        println("code ${intent?.data?.getQueryParameter("code")}")
    }
    private fun handleEvent(event: Event.Success) = when (event) {
        is Event.Success -> {
            shortToast("로그인 성공")
            setResult(1)
            finish()
        }
        else -> {
        }
    }

    private fun errorHandleEvent(event: Event.NotFound) = when (event) {
        is Event.NotFound -> {
            binding.etPassword.text = null
        }
        else -> {
            longToast("로그인 도중 문제가 발생하였습니다.")
        }
    }
    private fun initView() = binding.apply {
        etEmail.run {
            setOnTextChanged { p0, _, _, _ ->
                btnLogin.changeAtivatedWithEnabled(!p0.isNullOrBlank() && !binding.etPassword.text.isNullOrBlank())
            }
        }
        etPassword.run {
            setOnTextChanged { p0, _, _, _ ->
                btnLogin.changeAtivatedWithEnabled(!p0.isNullOrBlank() && !binding.etEmail.text.isNullOrBlank())
            }
        }
    }

    fun onClick(view: View){
      when(view){
          binding.ibtnBackButton -> {
              finish()
          }
          binding.loginLayout -> {
              keyBoardHide(this, listOf(binding.etEmail, binding.etPassword))
          }
          binding.btnLogin -> {
              loginViewModel.login(binding.etEmail.text.toString(), binding.etPassword.text.toString())
          }
          binding.tvFindPassword -> {
              startActivity(Intent(this,FindPasswordActivity::class.java))
          }
          binding.tvSignUp -> {
              startActivity(Intent(this, SignUpActivity::class.java))
          }

      }
  }
    override fun observeEvent() {
    }
}