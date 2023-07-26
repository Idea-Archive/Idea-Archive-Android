package com.team_ia.idea_archive_android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team_ia.domain.param.SendVerificationCodeParam
import com.team_ia.domain.param.SignupParam
import com.team_ia.domain.usecase.auth.SaveTokenUseCase
import com.team_ia.domain.usecase.auth.SignupUseCase
import com.team_ia.domain.usecase.email.CheckVerificationCodeUseCase
import com.team_ia.domain.usecase.email.SendVerificationCodeUseCase
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signupUseCase: SignupUseCase,
    private val sendVerificationCodeUseCase: SendVerificationCodeUseCase,
    private val checkVerificationCodeUseCase: CheckVerificationCodeUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
): ViewModel() {
    private val _signupInfo = MutableLiveData<Event>()
    val signupInfo : LiveData<Event> get() = _signupInfo
    private val _emailInfo = MutableLiveData<Event>()
    val emailInfo : LiveData<Event> get() = _emailInfo
    private val _authCodeInfo = MutableLiveData<Event>()
    val authCodeInfo : LiveData<Event> get() = _authCodeInfo
    private val _successInfo = MutableLiveData<Event>()
    val successInfo : LiveData<Event> get() = _successInfo

    fun signup (email: String, password: String, name: String) = viewModelScope.launch{
        signupUseCase(
            SignupParam(
                email, password, name
            )
        ).onSuccess {
            _signupInfo.value = Event.Success
        }.onFailure {
            _signupInfo.value =
                it.errorHandling(badRequestAction = {saveTokenUseCase()})
        }
    }

    fun authCodeIssuance(email: String) = viewModelScope.launch{
        sendVerificationCodeUseCase(
            SendVerificationCodeParam(
                email
            )
        ).onSuccess {
            _emailInfo.value = Event.Success
        }.onFailure {
            it.errorHandling(badRequestAction = {saveTokenUseCase()})
        }
    }

    fun authCodeCheck(email: String, authKey: Int) = viewModelScope.launch {
        checkVerificationCodeUseCase(
            email, authKey
        ).onSuccess {
            _authCodeInfo.value = Event.Success
        }.onFailure {
            it.errorHandling(badRequestAction = {saveTokenUseCase()})
        }
    }


    private val _emailData = MutableLiveData<String>()
    val emailData: LiveData<String> get() = _emailData
    private val _nameData = MutableLiveData<String>()
    val nameData: LiveData<String> get() = _nameData
    private val _passwordData = MutableLiveData<String>()
    val passwordData: LiveData<String> get() = _passwordData

    fun registerIdData(email: String, password: String, name: String) = viewModelScope.launch{
        _emailData.value = email
        _passwordData.value = password
        _nameData.value = name
    }

}