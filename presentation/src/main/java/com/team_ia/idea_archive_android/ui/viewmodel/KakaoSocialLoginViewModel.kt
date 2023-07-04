package com.team_ia.idea_archive_android.ui.viewmodel

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.team_ia.domain.param.SocialLoginParam
import com.team_ia.domain.usecase.auth.SaveTokenUseCase
import com.team_ia.domain.usecase.social.KakaoLoginUseCase
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.MutableEventFlow
import com.team_ia.idea_archive_android.utils.asEvetFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KakaoSocialLoginViewModel @Inject constructor(
    private val kakaoLoginUseCase: KakaoLoginUseCase,
    private val saveTokenUseCase: SaveTokenUseCase,
    application: Application,
) : AndroidViewModel(application) {
    private val _eventFlow = MutableEventFlow<Event>()
    private val context = getApplication<Application>().applicationContext
    val eventFlow = _eventFlow.asEvetFlow()

    private var _kakaoToken = MutableLiveData<String>()
    val kakaoToken: LiveData<String> get() = _kakaoToken

    private var _kakaoInfo = MutableLiveData<Boolean>()
    val kakaoInfo: LiveData<Boolean> get() = _kakaoInfo

    private var _loginInfo = MutableLiveData<Boolean>()
    val loginInfo: LiveData<Boolean> get() = _loginInfo

    fun checkKakaoLogin() = viewModelScope.launch {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)){
            _kakaoInfo.value = true
        }
    }

    fun kakaoLogin() = viewModelScope.launch {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                if (error != null) {
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    } else {
                        UserApiClient.instance.loginWithKakaoAccount(
                            context,
                            callback = {token, error ->  }
                        )
                    }
                }
            }
        }
    }

    fun login(token: String?) {
        Log.e("TAG", "viewModel")
        viewModelScope.launch {
            token?.let { SocialLoginParam(it) }?.let {
                kakaoLoginUseCase(it).onSuccess {
                    _loginInfo.value = true
                    Log.d("TAG", "Success")
                }.onFailure {
                    Log.d("TAG", "fail")
                }
            }
        }
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }
}