package com.team_ia.idea_archive_android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team_ia.domain.param.LoginParam
import com.team_ia.domain.usecase.auth.LoginUseCase
import com.team_ia.domain.usecase.auth.SaveTokenUseCase
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.MutableEventFlow
import com.team_ia.idea_archive_android.utils.asEvetFlow
import com.team_ia.idea_archive_android.utils.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
) : ViewModel() {
    private val _loginEvent = MutableLiveData<Event>()
    val loginEvent: LiveData<Event> get() = _loginEvent
    fun login(email: String, password: String) = viewModelScope.launch {
        loginUseCase(
            LoginParam(
                email, password
            )
        ).onSuccess {
            saveTokenUseCase(it.accessToken, it.refreshToken, it.expiredAt)
            _loginEvent.value = Event.Success
        }.onFailure {
            when(it.errorHandling()){
                Event.BadRequest -> {
                    _loginEvent.value = Event.BadRequest
                    saveTokenUseCase()
                }
                Event.NotFound -> {
                    _loginEvent.value = Event.NotFound
                    saveTokenUseCase()
                }
                else -> {}
            }
        }
    }

}