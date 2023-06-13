package com.team_ia.data.remote.datasource.social

import com.team_ia.data.remote.api.SocialAPI
import com.team_ia.data.remote.request.auth.SocialLoginRequest
import com.team_ia.data.remote.response.social.SocialLoginResponse
import com.team_ia.data.utils.IAApiHandler
import javax.inject.Inject

class SocialDataSourceImpl @Inject constructor(
    private val socialAPI: SocialAPI
) : SocialDataSource {
    override suspend fun socialLogin(socialLoginRequest: SocialLoginRequest): SocialLoginResponse {
        return IAApiHandler
    }
}