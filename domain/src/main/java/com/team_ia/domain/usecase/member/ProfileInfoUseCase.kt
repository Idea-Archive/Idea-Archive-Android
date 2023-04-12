package com.team_ia.domain.usecase.member

import com.team_ia.domain.param.MemberParam
import com.team_ia.domain.repository.MemberRepository
import javax.inject.Inject

class ProfileInfoUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke(memberParam: MemberParam) = kotlin.runCatching {
        memberRepository.profileInfo(memberParam)
    }
}