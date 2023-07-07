package com.team_ia.domain.usecase.auth

import com.team_ia.domain.param.SignupParam
import com.team_ia.domain.repository.AuthRepository
import javax.inject.Inject

class SignupUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(signupParam: SignupParam) = kotlin.runCatching {
        authRepository.signup(signupParam)
    }

}