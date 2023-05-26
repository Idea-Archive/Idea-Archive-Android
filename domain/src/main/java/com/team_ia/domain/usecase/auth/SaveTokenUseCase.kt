package com.team_ia.domain.usecase.auth

import com.team_ia.domain.repository.AuthRepository
import javax.inject.Inject

class SaveTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        accessToken: String,
        refreshToken: String,
        expiredAt: String
    ) =
        kotlin.runCatching {
            authRepository.saveToken(accessToken, refreshToken, expiredAt)
        }
}