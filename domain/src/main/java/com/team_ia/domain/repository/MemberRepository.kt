package com.team_ia.domain.repository

import com.team_ia.domain.entity.GetNoticeEntity
import com.team_ia.domain.entity.MemberEntity
import com.team_ia.domain.param.ChangeNickNameParam
import com.team_ia.domain.param.FindPasswordParam
import com.team_ia.domain.param.PasswordParam

interface MemberRepository {
    suspend fun profileInfo(): MemberEntity
    suspend fun changePassword(param: PasswordParam)
    suspend fun withdrawalMember(email: String, password: String)
    suspend fun findPassword(param: FindPasswordParam)
    suspend fun changeNickName(param: ChangeNickNameParam)
    suspend fun getNotice(): GetNoticeEntity
}