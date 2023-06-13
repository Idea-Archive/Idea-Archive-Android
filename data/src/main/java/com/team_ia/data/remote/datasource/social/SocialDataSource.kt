package com.team_ia.data.remote.datasource.social

import com.team_ia.data.remote.request.auth.SocialLoginRequest
import com.team_ia.data.remote.response.social.SocialLoginResponse

interface SocialDataSource {
    suspend fun socialLogin(socialLoginRequest: SocialLoginRequest): SocialLoginResponse
    suspend fun logout()
    suspend fun refreshToken(refreshToken: String): SocialLoginResponse


}