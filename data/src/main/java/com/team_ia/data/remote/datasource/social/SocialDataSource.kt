package com.team_ia.data.remote.datasource.social

import com.team_ia.data.remote.request.auth.SocialLoginRequest
import com.team_ia.data.remote.response.auth.LoginResponse

interface SocialDataSource {
    suspend fun googleLogin(socialLoginRequest: SocialLoginRequest): LoginResponse
    suspend fun kakaoLogin(socialLoginRequest: SocialLoginRequest): LoginResponse
    suspend fun logout()
    suspend fun refreshToken(refreshToken: String): LoginResponse


}