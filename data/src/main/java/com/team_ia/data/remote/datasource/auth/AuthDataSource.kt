package com.team_ia.data.remote.datasource.auth

import com.team_ia.data.remote.request.auth.LoginRequest
import com.team_ia.data.remote.request.auth.SignupRequest
import com.team_ia.data.remote.response.auth.LoginResponse

interface AuthDataSource {
    suspend fun login(loginRequest: LoginRequest): LoginResponse
    suspend fun signup(signupRequest: SignupRequest)
    suspend fun logout()
    suspend fun refreshToken(refreshToken: String): LoginResponse
}