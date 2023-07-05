package com.team_ia.domain.usecase.member

import com.team_ia.domain.repository.MemberRepository
import javax.inject.Inject

class GetMyPostUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke() = kotlin.runCatching {
        memberRepository.getMyPost()
    }

}