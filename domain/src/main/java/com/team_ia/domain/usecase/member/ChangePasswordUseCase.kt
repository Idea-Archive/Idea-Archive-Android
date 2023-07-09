package com.team_ia.domain.usecase.member

import com.team_ia.domain.param.PasswordParam
import com.team_ia.domain.repository.MemberRepository
import javax.inject.Inject

class ChangePasswordUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke(passwordParam: PasswordParam) = kotlin.runCatching {
        memberRepository.changePassword(passwordParam)
    }

}