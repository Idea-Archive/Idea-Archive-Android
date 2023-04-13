package com.team_ia.domain.repository

import com.team_ia.domain.entity.MemberEntity

interface MemberRepository {
    suspend fun profileInfo(): MemberEntity
}