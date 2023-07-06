package com.team_ia.domain.usecase.admin

import com.team_ia.domain.repository.AdminRepository
import javax.inject.Inject

class DetailNoticeUseCase @Inject constructor(
    private val adminRepository: AdminRepository
) {
    suspend operator fun invoke(noticeId: Long) = kotlin.runCatching {
        adminRepository.detailNotice(noticeId)
    }

}