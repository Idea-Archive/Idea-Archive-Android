package com.team_ia.domain.usecase.member

import com.team_ia.domain.param.ChangeNickNameParam
import com.team_ia.domain.repository.MemberRepository
import javax.inject.Inject

class ChangeNickNameUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke(changeNickNameParam: ChangeNickNameParam) = kotlin.runCatching {
        memberRepository.changeNickName(changeNickNameParam)
    }
}