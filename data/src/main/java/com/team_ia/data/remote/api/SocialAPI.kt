package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.auth.SocialLoginRequest
import com.team_ia.data.remote.response.social.SocialLoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SocialAPI {

    @POST("/google/login")
    suspend fun googleLogin(
        @Body socialLoginRequest: SocialLoginRequest
    ): SocialLoginResponse

}