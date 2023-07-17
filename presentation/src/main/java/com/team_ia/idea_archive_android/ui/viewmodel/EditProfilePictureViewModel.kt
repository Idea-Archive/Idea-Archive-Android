package com.team_ia.idea_archive_android.ui.viewmodel

import android.media.Image
import android.net.Uri
import android.util.Log
import androidx.core.net.toFile
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team_ia.domain.param.ChangeNickNameParam
import com.team_ia.domain.param.ChangeProfilePictureParam
import com.team_ia.domain.usecase.auth.SaveTokenUseCase
import com.team_ia.domain.usecase.img.ChangeProfilePictureUseCase
import com.team_ia.domain.usecase.member.ChangeNickNameUseCase
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.errorHandling
import com.team_ia.idea_archive_android.utils.toFile
import com.team_ia.idea_archive_android.utils.toMultipartBody
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import java.io.File
import javax.inject.Inject

@HiltViewModel
class EditProfilePictureViewModel @Inject constructor(
    private val changeProfilePictureUseCase: ChangeProfilePictureUseCase,
    private val changeNickNameUseCase: ChangeNickNameUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
) : ViewModel() {

    private val _profilePicture = MutableLiveData<MultipartBody.Part>()
    val profilePicture: LiveData<MultipartBody.Part> get() = _profilePicture

    private val _nickNameChangeInfo = MutableLiveData<Event>()
    val nickNameChangeInfo: LiveData<Event> get() = _nickNameChangeInfo

    private val _emailChangeInfo = MutableLiveData<Event>()
    val emailChangeInfo: LiveData<Event> get() = _emailChangeInfo

    private val _profilePictureInfo = MutableLiveData<Event>()
    val profilePictureInfo: LiveData<Event> get() = _profilePictureInfo

    fun saveProfilePicture(pictureUri: File) {
        _profilePicture.value = pictureUri.toMultipartBody()
    }

    fun approveChange(newNickName: String) {
        viewModelScope.launch {
            changeNickNameUseCase(
                ChangeNickNameParam(newNickName)
            ).onSuccess {
                _nickNameChangeInfo.value = Event.Success
            }.onFailure {
                _nickNameChangeInfo.value =
                    it.errorHandling(unauthorizedAction = { saveTokenUseCase() })
            }
            changeProfilePictureUseCase(
                ChangeProfilePictureParam(_profilePicture.value!!)
            ).onSuccess {
                _profilePictureInfo.value = Event.Success
            }.onFailure {
                _profilePictureInfo.value =
                    it.errorHandling(unauthorizedAction = { saveTokenUseCase() })
            }
        }
    }

}