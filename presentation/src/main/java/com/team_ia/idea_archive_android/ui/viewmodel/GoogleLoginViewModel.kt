package com.team_ia.idea_archive_android.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team_ia.domain.repository.GoogleLoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class GoogleLoginViewModel @Inject constructor(
    private val googleLoginRepository: GoogleLoginRepository
) : ViewModel(){

    suspend fun fetchGoogleAuthInfo(authCode: String) =
        withContext(viewModelScope.coroutineContext) {
            googleLoginRepository.fetchGoogleAuthInfo(authCode = authCode)
        }

}