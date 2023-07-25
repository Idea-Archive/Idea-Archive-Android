package com.team_ia.idea_archive_android.ui.main

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.FragmentSignUpPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.viewmodel.SignupViewModel
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.extension.setOnTextChanged
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpPageBinding>(R.layout.fragment_sign_up_page) {
    private val signupViewModel by activityViewModels<SignupViewModel>()
    override fun createView() {
        binding.signupfragment = SignUpFragment()
        onClick()
    }

    private fun initView() {
        binding.etInputEmail.run {
            setOnTextChanged { _, _, _, _ ->
            }
        }
    }

    private fun onClick() {
        binding.btnCheck.setOnClickListener {
            val email = binding.etInputEmail.text.toString()
            if (binding.etInputPassword.text.toString() == binding.etInputPasswordAgain.text.toString()) {
                signupViewModel.authCodeIssuance(email)
            } else {
                shortToast("비밀번호가 일치하지 않습니다.")
            }
        }
        binding.ibtnBackButton.setOnClickListener {
            requireActivity().findNavController(R.id.sign_up_container)
                .navigate(R.id.action_signUpFragment_to_loginActivity)
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
                    val savedEmailData = signupViewModel.emailData.value
                    if (savedEmailData != null) {
                        Log.e("This is not null", savedEmailData)
                    } else {
                        Log.e("this is null", "")
                    }
                    requireActivity().findNavController(R.id.sign_up_container)
                        .navigate(R.id.action_signUpFragment_to_authCodeInputFragment)
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

    private fun registerDataSetting() {
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