package com.team_ia.domain.usecase.auth

import com.team_ia.domain.param.LoginParam
import com.team_ia.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
){
    suspend operator fun invoke(loginParam: LoginParam) = kotlin.runCatching {
        authRepository.login(loginParam)
    }

}