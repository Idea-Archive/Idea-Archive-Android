package com.team_ia.domain.usecase.social

import com.team_ia.domain.param.SocialLoginParam
import com.team_ia.domain.repository.SocialRepository
import javax.inject.Inject

class KakaoLoginUseCase @Inject constructor(
    private val socialRepository: SocialRepository
) {
    suspend operator fun invoke(socialLoginParam: SocialLoginParam) = kotlin.runCatching {
        socialRepository.kakaoLogin(socialLoginParam)
    }

}