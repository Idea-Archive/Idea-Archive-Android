package com.team_ia.idea_archive_android.ui.profile

import android.content.Intent
import android.view.View
import com.team_ia.domain.entity.MemberEntity
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityEditProfileBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProfileActivity : BaseActivity<ActivityEditProfileBinding>(R.layout.activity_edit_profile) {
    private var profile: MemberEntity? = null

    override fun createView() {
        onClick()
        profile = intent.getSerializableExtra("profile") as MemberEntity
    }

    override fun observeEvent() {
    }

    fun onClickPageButton(view: View) {
        finish()
    }

    private fun onClick() {
        binding.btnEditProfile.setOnClickListener {
            startActivity(Intent(this, EditProfileInfoActivity::class.java).putExtra("profile", profile))
        }
        binding.btnEditPassword.setOnClickListener {
            startActivity(Intent(this, EditPasswordActivity::class.java).putExtra("profile", profile))
        }
        binding.btnWithdrawal.setOnClickListener {
            startActivity(Intent(this, WithdrawalActivity::class.java))
        }
    }

}