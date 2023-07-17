package com.team_ia.idea_archive_android.ui.profile

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityWithdrawalBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.login.LoginActivity
import com.team_ia.idea_archive_android.ui.viewmodel.MyViewModel
import com.team_ia.idea_archive_android.utils.Event
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WithdrawalActivity : BaseActivity<ActivityWithdrawalBinding>(R.layout.activity_withdrawal) {
    private val myViewModel by viewModels<MyViewModel>()


    override fun createView() {
        checkPassword()
        binding.btnWithdrawal.setOnClickListener {
            withdrawal()
        }
    }

    override fun observeEvent() {
        observeWithdrawal()
    }

    private fun checkPassword() {
        binding.etPassword.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.btnWithdrawal.isClickable = false
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.btnWithdrawal.isClickable = true
            }
        })
    }

    private fun withdrawal() {
        WithdrawalModal(this).let { dialog ->
            dialog.show()
            dialog.binding.btnWithdrawal.setOnClickListener {
                myViewModel.withdrawal(binding.etPassword.text.toString())
                dialog.dismiss()
            }
        }
    }

    private fun observeWithdrawal() {
        myViewModel.withdrawalInfo.observe(this) {
            when (it) {
                Event.Success -> {
                    shortToast("탈퇴성공!")
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                Event.BadRequest -> shortToast("비밀번호가 잘못되었습니다")
                else -> shortToast("알수없는 오류가 발생했습니다")
            }
        }
    }

}