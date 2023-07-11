package com.team_ia.idea_archive_android.ui.main

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivitySignUpPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.viewmodel.SignupViewModel
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.extension.changeAtivatedWithEnabled
import com.team_ia.idea_archive_android.utils.extension.setOnTextChanged
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : BaseActivity<ActivitySignUpPageBinding>(R.layout.activity_sign_up_page) {
    private val signupViewModel by viewModels<SignupViewModel>()
    override fun createView() {
        binding.signup = this
        initView()
    }

    private fun initView() = binding.apply {
        etInputEmail.run {
            setOnTextChanged { _, _, _, _ ->
                /*btnCheck.changeAtivatedWithEnabled(!etInputEmail.text.isNullOrBlank()
                        &&!etInputName.text.isNullOrBlank()
                        && !etInputPassword.text.isNullOrBlank()
                        && !etInputPasswordAgain.text.isNullOrBlank())*/
            }
        }
    }

    fun onClick(view: View) {
        when (view) {
            binding.btnCheck -> {
                val email = binding.etInputEmail.text.toString()
                if (binding.etInputPassword.text.toString() == binding.etInputPasswordAgain.text.toString()) {
                    signupViewModel.authCodeIssuance(email)
                } else {
                    shortToast("비밀번호가 일치하지 않습니다.")
                }
            }
            binding.tvAlreadyUserLogin -> {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
            binding.ibtnBackButton -> {
                finish()
            }
        }
    }

    override fun observeEvent() {
        observeSignUp()
    }

    private fun observeSignUp() {
        signupViewModel.signupInfo.observe(this) {
            when (it) {
                Event.Success -> {
                    Log.d("success", "")
                    registerDataSetting()
                    startActivity(Intent(this, AuthCodeInputActivity::class.java))
                    finish()
                }
                Event.BadRequest -> {
                    shortToast("제대로 된 이메일을 입력해주세요")
                }
                else -> {
                    shortToast("이메일 인증번호 발급 횟수를 초과 했어요.")
                }
            }
        }
    }

    private fun registerDataSetting(){
        val email = binding.etInputEmail.text.toString()
        val password = binding.etInputPassword.text.toString()
        val name = binding.etInputName.text.toString()

        signupViewModel.registerIdData(
            email = email,
            password = password,
            name = name
        )
    }
}