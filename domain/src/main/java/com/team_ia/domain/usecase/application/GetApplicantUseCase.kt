package com.team_ia.domain.usecase.application

import com.team_ia.domain.repository.ApplicationRepository
import javax.inject.Inject

class GetApplicantUseCase @Inject constructor(
    private val applicationRepository: ApplicationRepository
) {
    suspend operator fun invoke(postId: Long) = kotlin.runCatching {
        applicationRepository.getApplicant(postId)
    }

}