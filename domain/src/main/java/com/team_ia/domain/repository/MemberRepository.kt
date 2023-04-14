package com.team_ia.domain.repository

import com.team_ia.domain.entity.MemberEntity
import com.team_ia.domain.param.PasswordParam

interface MemberRepository {
    suspend fun profileInfo(): MemberEntity
    suspend fun changePassword(param: PasswordParam)
}