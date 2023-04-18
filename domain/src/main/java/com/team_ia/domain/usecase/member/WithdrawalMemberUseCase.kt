package com.team_ia.domain.usecase.member

import com.team_ia.domain.repository.MemberRepository
import javax.inject.Inject

class WithdrawalMemberUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke(email: String, password: String) = kotlin.runCatching {
        memberRepository.withdrawalMember(email = email, password = password)
    }
}