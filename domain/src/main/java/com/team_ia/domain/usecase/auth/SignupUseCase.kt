package com.team_ia.domain.usecase.auth

import com.team_ia.domain.repository.AuthRepository
import javax.inject.Inject

class SignupUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
}