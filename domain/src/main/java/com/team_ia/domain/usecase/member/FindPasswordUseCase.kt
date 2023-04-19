package com.team_ia.domain.usecase.member

import com.team_ia.domain.param.FindPasswordParam
import com.team_ia.domain.repository.MemberRepository
import javax.inject.Inject

class FindPasswordUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke(findPasswordParam: FindPasswordParam) = kotlin.runCatching {
        memberRepository.findPassword(findPasswordParam)
    }
}