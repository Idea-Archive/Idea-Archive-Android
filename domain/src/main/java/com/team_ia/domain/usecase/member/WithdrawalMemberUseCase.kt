package com.team_ia.domain.usecase.member

import com.team_ia.domain.param.WithdrawalMemberParam
import com.team_ia.domain.repository.MemberRepository
import javax.inject.Inject

class WithdrawalMemberUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke(withdrawalMemberParam: WithdrawalMemberParam) = kotlin.runCatching {
        memberRepository.withdrawalMember(withdrawalMemberParam)
    }

}