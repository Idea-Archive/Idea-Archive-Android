package com.team_ia.idea_archive_android.ui.profile

import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.activity.viewModels
import androidx.core.net.toFile
import coil.load
import coil.transform.CircleCropTransformation
import com.team_ia.domain.entity.MemberEntity
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityEditProfileInfoBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.viewmodel.EditProfilePictureViewModel
import com.team_ia.idea_archive_android.ui.viewmodel.MyViewModel
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.toFile
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProfileInfoActivity : BaseActivity<ActivityEditProfileInfoBinding>(R.layout.activity_edit_profile_info) {
    private val editProfilePictureViewModel by viewModels<EditProfilePictureViewModel>()
    private val myViewModel by viewModels<MyViewModel>()
    private val pickMedia = registerForActivityResult(PickVisualMedia()) { uri ->
        if (uri != null) {
            editProfilePictureViewModel.saveProfilePicture(uri.toFile(this))
            binding.ivProfile.load(uri) {
                crossfade(true)
                placeholder(R.drawable.bg_default_profile)
                transformations(CircleCropTransformation())
                binding.btnChangeProfilePicture.bringToFront()
            }
        }
    }
    private var profile: MemberEntity? = null

    override fun createView() {
        profile = intent.getSerializableExtra("profile") as MemberEntity
        binding.ivProfile.load(profile?.profileImg ?: R.drawable.bg_default_profile) {
            crossfade(true)
            placeholder(R.drawable.bg_default_profile)
            transformations(CircleCropTransformation())
            binding.btnChangeProfilePicture.bringToFront()
        }
        binding.profile = profile
        binding.btnChangeProfilePicture.setOnClickListener {
            pickImage(pickMedia)
        }
        onClick()
    }

    override fun observeEvent() {
        observeChange()
    }

    private fun pickImage(pickMedia: ActivityResultLauncher<PickVisualMediaRequest>) {
        pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
    }

    private fun approveChange() {
        val newNickName = binding.etName.text.toString()
        editProfilePictureViewModel.approveChange(newNickName)
    }

    private fun onClick() {
        binding.btnConfirm.setOnClickListener {
            approveChange()
        }
    }

    private fun observeChange() {
        var nickNameInfo = 0
        var profilePictureInfo = 0
        editProfilePictureViewModel.nickNameChangeInfo.observe(this) { it ->
            when (it) {
                Event.Success -> nickNameInfo = 1
                else -> Log.e("TAG", "Fail")
            }
            editProfilePictureViewModel.profilePictureInfo.observe(this) {
                when (it) {
                    Event.Success -> profilePictureInfo = 1
                    else -> Log.e("TAG", "Fail")
                }
                onSuccess(nickNameInfo, profilePictureInfo)
            }
        }

    }

    private fun onSuccess(nickNameInfo: Int, profilePictureInfo: Int) {
        if (nickNameInfo == 1 && profilePictureInfo == 1) {
            shortToast("프로필 변경 성공!")
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
    }

}