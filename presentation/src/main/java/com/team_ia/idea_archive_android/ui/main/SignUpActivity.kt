package com.team_ia.idea_archive_android.ui.main

import android.content.Intent
import android.view.View
import androidx.activity.viewModels
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivitySignUpPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.viewmodel.SignupViewModel
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

    fun initView() = binding.apply {
        etInputEmail.run {
            setOnTextChanged { p0, _, _, _ ->
                btnCheck.changeAtivatedWithEnabled(p0.isNullOrBlank()
                        && etInputPassword.text.toString() == etInputPasswordAgain.text.toString())
            }
        }
    }

    fun onClick(view: View){
        when(view){
            binding.btnCheck -> {
                if (binding.etInputEmail.text.isNullOrBlank() && binding.etInputName.text.isNullOrBlank()
                    && binding.etInputPassword.text.isNullOrBlank() && binding.etInputPasswordAgain.text.isNullOrBlank())
                {
                    if ( binding.etInputPassword.text == binding.etInputPasswordAgain.text) {
                        signupViewModel.registerIdData(
                            binding.etInputEmail.text.toString(),
                            binding.etInputPassword.text.toString(),
                            binding.etInputName.text.toString()
                        )
                        signupViewModel.authCodeIssuance(binding.etInputEmail.text.toString())
                        startActivity(Intent(this, AuthCodeInputActivity::class.java))
                        finish()
                    }
                    else{
                        shortToast("비밀번호가 서로 일치 하지 않습니다.")
                    }
                }else{
                    shortToast("비어있는 칸이 없이 채워주세요.")
                }
            }
            binding.tvAlreadyUserLogin -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            binding.ibtnBackButton -> {
                finish()
            }
        }
    }

    override fun observeEvent() {
    }
}