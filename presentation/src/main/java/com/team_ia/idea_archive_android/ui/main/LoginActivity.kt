package com.team_ia.idea_archive_android.ui.main

import android.content.Intent
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.team_ia.idea_archive_android.BuildConfig
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityLoginPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.viewmodel.LoginViewModel
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.extension.changeAtivatedWithEnabled
import com.team_ia.idea_archive_android.utils.extension.repeatOnStart
import com.team_ia.idea_archive_android.utils.extension.setOnTextChanged
import com.team_ia.idea_archive_android.utils.keyBoardHide

class LoginActivity : BaseActivity<ActivityLoginPageBinding>(R.layout.activity_login_page) {
    private val loginViemodel by viewModels<LoginViewModel>()

    companion object {
        private val RC_SIGN_IN: Int = 9001
    }

    private lateinit var mSignInClient: GoogleSignInClient
    private lateinit var loginLauncher: ActivityResultLauncher<Intent>

    override fun createView() {
        binding.login = this
        initView()
        repeatOnStart {
            loginViemodel.eventFlow.collect {event -> handleEvent(event as Event.Success)}
        }
        repeatOnStart {
            loginViemodel.eventFlow.collect {event -> errorHandleEvent(event as Event.NotFound)}
        }

        val googleClientId = BuildConfig.GOOGLE_CLIENT_ID
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestServerAuthCode(googleClientId)
            .requestEmail()
            .build()
        val client = GoogleSignIn.getClient(this, gso)

        loginLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            println("인가코드 ${result}")
            if (result.resultCode == RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                println("인가코드 ${task.result?.serverAuthCode}")
            }
        }

        mSignInClient = GoogleSignIn.getClient(this, gso)

        binding.ibtnGoogleLg.setOnClickListener { view ->
            loginLauncher.launch(client.signInIntent)
        }

    }

    private fun handleEvent(event: Event.Success) = when(event){
        is Event.Success -> {
            shortToast("로그인 성공")
            setResult(1)
            finish()
        }
        else ->{

        }
    }

    private fun errorHandleEvent(event: Event.NotFound) = when(event){
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
        etPassword.run{
            setOnTextChanged { p0, _, _, _ ->
                btnLogin.changeAtivatedWithEnabled(!p0.isNullOrBlank() && !binding.etEmail.text.isNullOrBlank())
            }
        }
    }

  private fun onClick(view: View){
      when(view){
          binding.ibtnBackButton -> {
              finish()
          }
          binding.loginLayout -> {
              keyBoardHide(this, listOf(binding.etEmail, binding.etPassword))
          }
          binding.btnLogin -> {
              loginViemodel.login(binding.etEmail.text.toString(), binding.etPassword.text.toString())
          }
          binding.tvFindPassword -> {
              startActivity(Intent(this,FindPasswordActivity::class.java))
          }
          binding.tvSignUp -> {
              startActivity(Intent(this, SignUpActivity::class.java))
          }

      }
  }

}