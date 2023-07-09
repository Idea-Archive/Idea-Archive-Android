package com.team_ia.idea_archive_android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team_ia.domain.param.FindPasswordParam
import com.team_ia.domain.usecase.auth.SaveTokenUseCase
import com.team_ia.domain.usecase.member.FindPasswordUseCase
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChangePasswordViewModel @Inject constructor(
    private val findPasswordUseCase: FindPasswordUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
)  : ViewModel() {

    private val _changePasswordInfo = MutableLiveData<Event>()
    val changePasswordInfo: LiveData<Event> get() = _changePasswordInfo

    fun changePassword(password: String, newPassword: String) {
        viewModelScope.launch {
            findPasswordUseCase(
                FindPasswordParam(
                    password,
                    newPassword
                )
            ).onSuccess {
                _changePasswordInfo.value = Event.Success
            }.onFailure {
                _changePasswordInfo.value =
                    it.errorHandling(unauthorizedAction = { saveTokenUseCase() })
            }
        }
    }

}