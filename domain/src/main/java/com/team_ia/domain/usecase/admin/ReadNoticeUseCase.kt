package com.team_ia.domain.usecase.admin

import com.team_ia.domain.repository.AdminRepository
import javax.inject.Inject

class ReadNoticeUseCase @Inject constructor(
    private val adminRepository: AdminRepository
) {
    suspend operator fun invoke() = kotlin.runCatching {
        adminRepository.readNotice()
    }

}