package com.team_ia.idea_archive_android.ui.main

import android.util.Log
import androidx.fragment.app.activityViewModels
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.FragmentAuthCodeInputPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.viewmodel.SignupViewModel
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.extension.setOnTextChanged
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthCodeInputFragment :
    BaseFragment<FragmentAuthCodeInputPageBinding>(R.layout.fragment_auth_code_input_page) {
    private val signupViewModel by activityViewModels<SignupViewModel>()
    override fun createView() {
        binding.authCodeInput = this
        onClick()
        initView()

    }

    fun initView() = binding.apply {
        etInputAuthCode1.run {
            setOnTextChanged { _, _, _, _ ->
                etInputAuthCode2.requestFocus()
            }
        }
        etInputAuthCode2.run{
            setOnTextChanged { _, _, _, _ ->
                etInputAuthCode3.requestFocus()
            }
        }
        etInputAuthCode3.run {
            setOnTextChanged { _, _, _, _ ->
                etInputAuthCode4.requestFocus()
            }
        }
    }

    private fun onClick() {
        binding.btnCheck.setOnClickListener {
            val email = signupViewModel.emailData.value
            Log.d("email:", "${email}")
            val authKey =
                binding.etInputAuthCode1.text.toString() + binding.etInputAuthCode2.text.toString() +
                        binding.etInputAuthCode3.text.toString() + binding.etInputAuthCode4.text.toString()
            if (!email.isNullOrBlank()) {
                signupViewModel.authCodeCheck(email = email, authKey = authKey.toInt())
            } else {
                Log.d("email :", "${email}")
            }
        }
    }


    override fun observeEvent() {
        observeSignUp()
    }

    private fun observeSignUp() {
        val email = signupViewModel.emailData.value
        val password = signupViewModel.passwordData.value
        val name = signupViewModel.nameData.value
        signupViewModel.signupInfo.observe(this) {
            when (it) {
                Event.Success -> {
                    signupViewModel.signup(email!!, password!!, name!!)

                }
                Event.BadRequest -> {
                    shortToast("인증번호가 일치하지 않습니다.")
                }
                Event.Unauthorized -> {
                    shortToast("인증 시간이 만료되었어요.")
                }
                else -> {}
            }
        }
    }

}