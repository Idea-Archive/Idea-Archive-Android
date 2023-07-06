package com.team_ia.domain.usecase.admin

import com.team_ia.domain.param.PostNoticeParam
import com.team_ia.domain.repository.AdminRepository
import javax.inject.Inject

class PostNoticeUseCase @Inject constructor(
    private val adminRepository: AdminRepository
) {
    suspend operator fun invoke(postNoticeParam: PostNoticeParam) = kotlin.runCatching {
        adminRepository.postNotice(postNoticeParam)
    }

}