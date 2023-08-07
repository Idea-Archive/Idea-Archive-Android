package com.team_ia.idea_archive_android.ui.profile

import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityEditPasswordBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.viewmodel.ChangePasswordViewModel
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.keyBoardHide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditPasswordActivity : BaseActivity<ActivityEditPasswordBinding>(R.layout.activity_edit_password) {
    private val changePasswordViewModel by viewModels<ChangePasswordViewModel>()

    override fun createView() {
        binding.btnConfirm.isClickable = false
        onLayoutClicked()
        binding.btnConfirm.setOnClickListener { changePassword() }
    }

    override fun observeEvent() {
        observeChangePassword()
    }

    private fun onLayoutClicked() {
        binding.passwordLayout.setOnClickListener {
            val password = binding.etPassword.text
            val newPassword = binding.etNewPassword.text
            if (password != newPassword) {
                binding.tvIncorrectNewPassword.isVisible = true
                binding.vIncorrectNewPassword.isVisible = true
            } else binding.btnConfirm.isClickable = true
            keyBoardHide(this, listOf(binding.etPassword, binding.etNewPassword))
        }
    }

    private fun changePassword() {
        val password = binding.etPassword.text.toString()
        val newPassword = binding.etNewPassword.toString()
        changePasswordViewModel.changePassword(password, newPassword)
    }

    private fun observeChangePassword() {
        changePasswordViewModel.changePasswordInfo.observe(this) {
            when (it) {
                Event.Success -> {
                    shortToast("비밀번호가 변경되었습니다")
                    startActivity(Intent(this, EditProfileActivity::class.java))
                    finish()
                }
                Event.Unauthorized -> {
                    longToast("이메일 인증이 진행되지 않았습니다, 다시 진행해 주세요")
                    startActivity(Intent(this, EditProfileActivity::class.java))
                    finish()
                }
                Event.BadRequest -> {
                    binding.tvIncorrectPassword.isVisible = true
                    binding.vIncorrectPassword.isVisible = true
                }
                else -> {
                    shortToast("알수없는 오류가 발생했습니다")
                    Log.e("TAG", "${it}")
                    startActivity(Intent(this, EditProfileActivity::class.java))
                    finish()
                }
            }
        }
    }

}