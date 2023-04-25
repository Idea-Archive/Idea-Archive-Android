package com.team_ia.domain.repository

import com.team_ia.domain.entity.LoginEntity
import com.team_ia.domain.param.LoginParam
import com.team_ia.domain.param.SignupParam

interface AuthRepository {
    suspend fun login(loginParam: LoginParam): LoginEntity
    suspend fun signup(signupParam: SignupParam)
}