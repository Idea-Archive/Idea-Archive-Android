package com.team_ia.data.remote.api

import SocialLoginResponse
import com.team_ia.data.remote.request.auth.SocialLoginRequest
import com.team_ia.data.remote.response.auth.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface SocialAPI {

    @GET("/google/login")
    suspend fun googleLogin(
       @Query("authorizationCode")socialLoginRequest: SocialLoginRequest
    ): SocialLoginResponse

    @DELETE
    suspend fun logout(): Response<Unit>

    @PATCH
    suspend fun refreshToken(
        @Header("refreshToken") refreshToken: String
    ): SocialLoginResponse
}