package com.team_ia.idea_archive_android.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team_ia.domain.repository.SocialRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class GoogleLoginViewModel @Inject constructor(
    private val socialRepository: SocialRepository
) : ViewModel(){

    suspend fun fetchGoogleAuthInfo(authCode: String) =
        withContext(viewModelScope.coroutineContext) {
            socialRepository.fetchGoogleAuthInfo(authCode = authCode)
        }

}