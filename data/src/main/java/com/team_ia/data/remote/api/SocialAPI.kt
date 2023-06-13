package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.auth.SocialLoginRequest
import com.team_ia.data.remote.response.auth.LoginResponse
import com.team_ia.data.remote.response.social.SocialLoginResponse
import retrofit2.Response
import retrofit2.http.*

interface SocialAPI {

    @POST("/google/login")
    suspend fun googleLogin(
        @Body socialLoginRequest: SocialLoginRequest
    ): SocialLoginResponse

    @DELETE
    suspend fun logout(): Response<Unit>

    @PATCH
    suspend fun refreshToken(
        @Header("refreshToken") refreshToken: String
    ): SocialLoginResponse
}