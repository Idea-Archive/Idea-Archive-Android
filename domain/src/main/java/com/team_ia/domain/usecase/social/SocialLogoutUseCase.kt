package com.team_ia.domain.usecase.social

import com.team_ia.domain.param.SocialLoginParam
import com.team_ia.domain.repository.SocialRepository
import javax.inject.Inject

class SocialLogoutUseCase @Inject constructor(
    private val socialRepository: SocialRepository
) {
    suspend operator fun invoke() = kotlin.runCatching {
        socialRepository.logout()
    }
}