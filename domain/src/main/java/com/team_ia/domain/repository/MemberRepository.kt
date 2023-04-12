package com.team_ia.domain.repository

import com.team_ia.domain.entity.MemberEntity
import com.team_ia.domain.param.MemberParam

interface MemberRepository {
    suspend fun profileInfo(memberParam: MemberParam): MemberEntity
}