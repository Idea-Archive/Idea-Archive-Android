package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.auth.LoginRequest
import com.team_ia.data.remote.response.auth.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {
    @POST("/login")
    suspend fun login(
        @Body loginRequest: LoginRequest,
    ): LoginResponse
}