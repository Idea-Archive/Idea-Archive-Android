package com.team_ia.domain.usecase.admin

import com.team_ia.domain.param.EditNoticeParam
import com.team_ia.domain.repository.AdminRepository
import javax.inject.Inject

class EditNoticeUseCase @Inject constructor(
    private val adminRepository: AdminRepository
) {
    suspend operator fun invoke(noticeId: Long, editNoticeParam: EditNoticeParam) = kotlin.runCatching {
        adminRepository.editNotice(noticeId, editNoticeParam)
    }

}