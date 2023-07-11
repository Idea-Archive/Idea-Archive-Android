package com.team_ia.idea_archive_android.ui.main

import android.content.Intent
import android.view.View
import androidx.activity.viewModels
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityAuthCodeInputPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.viewmodel.SignupViewModel
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.extension.setOnTextChanged
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthCodeInputActivity: BaseActivity<ActivityAuthCodeInputPageBinding>(R.layout.activity_auth_code_input_page) {
    private val signupViewModel by viewModels<SignupViewModel>()
    override fun createView() {
        binding.authCodeInput = this

    }
    fun initView() = binding.apply {
        etInputAuthCode1.run {
            setOnTextChanged { p0, _, _, _ ->

            }
        }
    }

    fun onClick(view: View){
        when(view){
            binding.btnCheck -> {
                val email = signupViewModel.emailData.value
                val authKey = binding.etInputAuthCode1.text.toString() + binding.etInputAuthCode2.text.toString() +
                        binding.etInputAuthCode3.text.toString() + binding.etInputAuthCode4.text.toString()
                if (authKey.isBlank()){
                    signupViewModel.authCodeCheck(email = email!!, authKey = authKey.toInt())
                }
            }
        }
    }

    override fun observeEvent() {
        observeSignUp()
    }

    private fun observeSignUp(){
        val email = signupViewModel.emailData.value
        val password = signupViewModel.passwordData.value
        val name = signupViewModel.nameData.value
        signupViewModel.signupInfo.observe(this){
            val successInfo = signupViewModel.successInfo.value
            when (it){
                Event.Success -> {
                    signupViewModel.signup(email!!, password!!, name!!)
                    when (successInfo){
                        Event.Success -> {
                            startActivity(Intent(this, AuthenticationSuccessActivity::class.java))
                            finish()
                        }
                        Event.Unauthorized -> {
                            startActivity(Intent(this, AuthenticationFailedActivity::class.java))
                            finish()
                        }
                        else -> {}
                    }
                }
                Event.BadRequest -> {
                    shortToast("인증번호가 일치하지 않습니다.")
                }
                Event.Unauthorized ->{
                    shortToast("인증 시간이 만료되었어요.")
                    startActivity(Intent(this, SignUpActivity::class.java))
                    finish()
                }
                else -> {}
            }
        }
    }

}