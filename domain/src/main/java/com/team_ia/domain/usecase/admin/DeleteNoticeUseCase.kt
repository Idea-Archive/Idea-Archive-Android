package com.team_ia.domain.usecase.admin

import com.team_ia.domain.repository.AdminRepository
import javax.inject.Inject

class DeleteNoticeUseCase @Inject constructor(
    private val adminRepository: AdminRepository
) {
    suspend operator fun invoke(noticeId: Long) = kotlin.runCatching {
        adminRepository.deleteNotice(noticeId)
    }

}