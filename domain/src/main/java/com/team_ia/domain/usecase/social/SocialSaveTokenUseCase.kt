package com.team_ia.domain.usecase.social

import com.team_ia.domain.repository.SocialRepository
import javax.inject.Inject

class SocialSaveTokenUseCase @Inject constructor(
    private val socialRepository: SocialRepository
) {

    suspend operator fun invoke(
        accessToken: String,
        refreshToken: String,
        expiredAt: String
    ) =
        kotlin.runCatching {
            socialRepository.saveToken(accessToken, refreshToken, expiredAt)
        }
}