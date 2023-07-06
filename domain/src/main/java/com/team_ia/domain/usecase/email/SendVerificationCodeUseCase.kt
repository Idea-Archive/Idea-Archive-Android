package com.team_ia.domain.usecase.email

import com.team_ia.domain.param.SendVerificationCodeParam
import com.team_ia.domain.repository.EmailRepository
import javax.inject.Inject

class SendVerificationCodeUseCase @Inject constructor(
    private val emailRepository: EmailRepository
) {
    suspend operator fun invoke(sendVerificationCodeParam: SendVerificationCodeParam) = kotlin.runCatching {
        emailRepository.sendVerificationCode(sendVerificationCodeParam)
    }

}