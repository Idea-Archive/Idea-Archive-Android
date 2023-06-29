package com.team_ia.idea_archive_android.ui.viewmodel

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
import org.xml.sax.ErrorHandler
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
): ViewModel(){
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEvetFlow()

    fun login (email:String, password:String) = viewModelScope.launch{
        loginUseCase(
            LoginParam(
                email, password
            )
        ).onSuccess {
            saveTokenUseCase(it.accessToken, it.refreshToken, it.expiredAt)
            event(Event.Success)
        }.onFailure {
            event(it.errorHandling(notFoundAction = {
                saveTokenUseCase()
            }))
        }
    }

    private fun event(event: Event) = viewModelScope.launch{
        _eventFlow.emit(event)
    }

}