package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.auth.LoginRequest
import com.team_ia.data.remote.request.auth.SignupRequest
import com.team_ia.data.remote.response.auth.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST

interface AuthAPI {

    @POST("/auth/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): LoginResponse

    @POST("/auth/signup")
    suspend fun signup(
        @Body signupRequest: SignupRequest
    ): Response<Unit>

    @DELETE("/auth")
    suspend fun logout(): Response<Unit>

    @PATCH("/auth")
    suspend fun refreshToken(
        @Header("refreshToken") refreshToken: String
    ): LoginResponse
}