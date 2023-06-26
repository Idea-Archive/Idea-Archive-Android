package com.team_ia.domain.usecase.email

import com.team_ia.domain.repository.EmailRepository
import javax.inject.Inject

class CheckVerificationCodeUseCase @Inject constructor(
    private val emailRepository: EmailRepository
) {
    suspend operator fun invoke(email: String, authKey: Int) = kotlin.runCatching {
        emailRepository.checkVerificationCode(email = email, authKey = authKey)
    }
}