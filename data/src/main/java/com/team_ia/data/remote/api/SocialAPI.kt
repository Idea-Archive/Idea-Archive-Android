package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.auth.SocialLoginRequest
import com.team_ia.data.remote.response.auth.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface SocialAPI {

    @GET("/google/login")
    suspend fun googleLogin(
       @Query("authorizationCode")socialLoginRequest: SocialLoginRequest
    ): LoginResponse

    @GET("/kakao/login")
    suspend fun kakaoLogin(
        @Query("authorizationCode")socialLoginRequest: SocialLoginRequest
    ): LoginResponse

    @DELETE
    suspend fun logout(): Response<Unit>

    @PATCH
    suspend fun refreshToken(
        @Header("refreshToken") refreshToken: String
    ): LoginResponse
}