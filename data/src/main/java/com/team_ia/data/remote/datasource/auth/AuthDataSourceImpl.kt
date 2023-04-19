package com.team_ia.data.remote.datasource.auth

import com.team_ia.data.remote.api.AuthAPI
import com.team_ia.data.remote.request.auth.LoginRequest
import com.team_ia.data.remote.response.auth.LoginResponse
import com.team_ia.data.utils.IAApiHandler
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authAPI: AuthAPI
) : AuthDataSource {
    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
       return IAApiHandler<LoginResponse>()
            .httpRequest { authAPI.login(loginRequest = loginRequest) }
            .sendRequest()
    }
}