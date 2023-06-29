package com.team_ia.idea_archive_android.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.team_ia.domain.usecase.auth.LogoutUseCase
import com.team_ia.domain.usecase.auth.SaveTokenUseCase
import com.team_ia.domain.usecase.social.KakaoLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KakaoSocialLoginViewModel @Inject constructor(
    private val kakaoLoginUseCase: KakaoLoginUseCase,
    private val saveTokenUseCase: SaveTokenUseCase,
) : ViewModel(){
}