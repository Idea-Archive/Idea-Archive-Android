package com.team_ia.data.repository

import com.team_ia.data.remote.response.auth.LoginGoogleResponse
import com.team_ia.data.service.LoginService
import com.team_ia.domain.repository.GoogleLoginRepository
import java.util.prefs.Preferences
import javax.inject.Inject

class GoogleLoginRepositoryImpl @Inject constructor(
    private val preferences: Preferences,
    private val service: LoginService
    ) : GoogleLoginRepository{
    override suspend fun fetchGoogleAuthInfo(authCode: String): Result<LoginGoogleResponse> {
        TODO("Not yet implemented")
    }
}