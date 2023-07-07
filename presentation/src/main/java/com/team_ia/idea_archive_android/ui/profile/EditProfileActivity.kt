package com.team_ia.idea_archive_android.ui.profile

import android.content.Intent
import android.view.View
import androidx.activity.viewModels
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityEditProfileBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.main.LoginActivity
import com.team_ia.idea_archive_android.ui.viewmodel.MyViewModel
import com.team_ia.idea_archive_android.utils.Event
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProfileActivity : BaseActivity<ActivityEditProfileBinding>(R.layout.activity_edit_profile) {

    override fun createView() {
        onClick()
    }

    override fun observeEvent() {
    }

    fun onClickPageButton(view: View) {
        finish()
    }

    private fun onClick() {
        binding.btnEditProfile.setOnClickListener {
            startActivity(Intent(this, EditProfileInfoActivity::class.java))
        }
        binding.btnEditPassword.setOnClickListener {
            startActivity(Intent(this, EditPasswordActivity::class.java))
        }
        binding.btnWithdrawal.setOnClickListener {
            startActivity(Intent(this, WithdrawalActivity::class.java))
        }
    }

}