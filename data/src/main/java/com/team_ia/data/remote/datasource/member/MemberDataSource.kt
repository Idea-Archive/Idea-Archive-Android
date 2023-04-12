package com.team_ia.data.remote.datasource.member

import com.team_ia.data.remote.request.member.MemberRequest
import com.team_ia.data.remote.response.member.MemberResponse

interface MemberDataSource {
    suspend fun profileInfo(memberRequest: MemberRequest): MemberResponse
}