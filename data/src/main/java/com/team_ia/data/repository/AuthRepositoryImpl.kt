package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.auth.AuthDataSource
import com.team_ia.data.remote.request.auth.toRequest
import com.team_ia.data.remote.response.auth.toEntity
import com.team_ia.domain.entity.LoginEntity
import com.team_ia.domain.param.LoginParam
import com.team_ia.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDatasource: AuthDataSource
) : AuthRepository {
    override suspend fun login(loginParam: LoginParam): LoginEntity =
        authDatasource.login(loginParam.toRequest()).toEntity()
}