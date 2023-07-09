package com.team_ia.idea_archive_android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team_ia.domain.entity.MemberEntity
import com.team_ia.domain.model.PostModel
import com.team_ia.domain.param.WithdrawalMemberParam
import com.team_ia.domain.usecase.auth.SaveTokenUseCase
import com.team_ia.domain.usecase.member.GetMyHeartListUseCase
import com.team_ia.domain.usecase.member.GetMyPostUseCase
import com.team_ia.domain.usecase.member.GetProfileInfoUseCase
import com.team_ia.domain.usecase.member.WithdrawalMemberUseCase
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val getProfileInfoUseCase: GetProfileInfoUseCase,
    private val getMyHeartListUseCase: GetMyHeartListUseCase,
    private val getMyPostUseCase: GetMyPostUseCase,
    private val withdrawalMemberUseCase: WithdrawalMemberUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
) : ViewModel() {

    private val _profileData = MutableLiveData<MemberEntity>()
    val profileData: LiveData<MemberEntity> get() = _profileData

    private val _postData = MutableLiveData<List<PostModel>>()
    val postData: LiveData<List<PostModel>> get() = _postData

    private var _getProfileInfo = MutableLiveData<Event>()
    val getProfileInfo: LiveData<Event> get() = _getProfileInfo

    private var _editProfileInfo = MutableLiveData<Event>()
    val editProfileInfo: LiveData<Event> get() = _editProfileInfo

    private var _getPostInfo = MutableLiveData<Event>()
    val getPostInfo: LiveData<Event> get() = _getPostInfo

    private var _withdrawalInfo = MutableLiveData<Event>()
    val withdrawalInfo: LiveData<Event> get() = _withdrawalInfo

    fun getProfile() {
        viewModelScope.launch {
            getProfileInfoUseCase().onSuccess {
                _profileData.value = it
                _getProfileInfo.value = Event.Success
                _editProfileInfo.value = Event.Success
            }.onFailure {
                _getProfileInfo.value =
                    it.errorHandling(unauthorizedAction = { saveTokenUseCase() })
                _editProfileInfo.value =
                    it.errorHandling(unauthorizedAction = { saveTokenUseCase() })
            }
        }
    }

    fun getPost(type: Int) {
        viewModelScope.launch {
            when (type) {
                0 -> getMyHeartListUseCase().onSuccess {
                    _postData.value = it
                    _getPostInfo.value = Event.Success
                }.onFailure {
                    _getPostInfo.value =
                        it.errorHandling(notFoundAction = { saveTokenUseCase() })
                }
                1 -> getMyPostUseCase().onSuccess {
                    _postData.value = it
                    _getPostInfo.value = Event.Success
                }.onFailure {
                    _getPostInfo.value =
                        it.errorHandling(notFoundAction = { saveTokenUseCase() })
                }
            }
        }
    }

    fun withdrawal(password: String) {
        viewModelScope.launch {
            withdrawalMemberUseCase(
                WithdrawalMemberParam(
                    email = _profileData.value!!.email,
                    password = password
                )
            ).onSuccess {
                _withdrawalInfo.value = Event.Success
                saveTokenUseCase()
            }.onFailure {
                _withdrawalInfo.value = it.errorHandling(unauthorizedAction = { saveTokenUseCase() })
            }
        }
    }


}