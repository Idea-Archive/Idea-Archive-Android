package com.team_ia.idea_archive_android.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team_ia.domain.param.SendVerificationCodeParam
import com.team_ia.domain.param.SignupParam
import com.team_ia.domain.usecase.auth.SaveTokenUseCase
import com.team_ia.domain.usecase.auth.SignupUseCase
import com.team_ia.domain.usecase.email.SendVerificationCodeUseCase
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.MutableEventFlow
import com.team_ia.idea_archive_android.utils.asEvetFlow
import com.team_ia.idea_archive_android.utils.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signupUseCase: SignupUseCase,
    private val sendVerificationCodeUseCase: SendVerificationCodeUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
): ViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEvetFlow()

    fun signup (email: String, password: String, name: String) = viewModelScope.launch{
        signupUseCase(
            SignupParam(
                email, password, name
            )
        ).onSuccess {
            event(Event.Success)
        }.onFailure {
            event(it.errorHandling(notFoundAction = {
                saveTokenUseCase()
            }
            ))
        }
    }

    fun authCodeIssuance(email: String) = viewModelScope.launch{
        sendVerificationCodeUseCase(
            SendVerificationCodeParam(
                email
            )
        ).onSuccess {
            event(Event.Success)
        }.onFailure {
            event(it.errorHandling (badRequestAction = {
                saveTokenUseCase()
            }
            ))
        }
    }


    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

}