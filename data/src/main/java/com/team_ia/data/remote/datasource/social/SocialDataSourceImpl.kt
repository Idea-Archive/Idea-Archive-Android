package com.team_ia.data.remote.datasource.social

import com.team_ia.data.remote.api.SocialAPI
import com.team_ia.data.remote.request.auth.SocialLoginRequest
import com.team_ia.data.remote.response.auth.LoginResponse
import com.team_ia.data.utils.IAApiHandler
import javax.inject.Inject

class SocialDataSourceImpl @Inject constructor(
    private val socialAPI: SocialAPI
) : SocialDataSource {
    override suspend fun googleLogin(socialLoginRequest: SocialLoginRequest): LoginResponse {
        return IAApiHandler<LoginResponse>()
            .httpRequest { socialAPI.googleLogin(socialLoginRequest) }
            .sendRequest()
    }

    override suspend fun kakaoLogin(socialLoginRequest: SocialLoginRequest): LoginResponse{
        return IAApiHandler<LoginResponse>()
            .httpRequest { socialAPI.kakaoLogin(socialLoginRequest) }
            .sendRequest()
    }

    override suspend fun logout() {
        return IAApiHandler<Unit>()
            .httpRequest { socialAPI.logout() }
            .sendRequest()
    }

    override suspend fun refreshToken(refreshToken: String): LoginResponse {
        return IAApiHandler<LoginResponse>()
            .httpRequest { socialAPI.refreshToken(refreshToken) }
            .sendRequest()
    }

}