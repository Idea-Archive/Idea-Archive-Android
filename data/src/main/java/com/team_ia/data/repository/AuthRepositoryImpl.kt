package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.auth.AuthDataSource
import com.team_ia.data.remote.request.auth.toRequest
import com.team_ia.data.remote.response.auth.toEntity
import com.team_ia.domain.entity.LoginEntity
import com.team_ia.domain.param.LoginParam
import com.team_ia.domain.param.SignupParam
import com.team_ia.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDatasource: AuthDataSource
) : AuthRepository {
    override suspend fun login(param: LoginParam): LoginEntity =
        authDatasource.login(param.toRequest()).toEntity()

    override suspend fun signup(param: SignupParam) =
        authDatasource.signup(param.toRequest())

    override suspend fun logout() =
        authDatasource.logout()

}