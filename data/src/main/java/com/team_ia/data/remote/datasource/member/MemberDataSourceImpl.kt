package com.team_ia.data.remote.datasource.member

import com.team_ia.data.remote.api.MemberAPI
import com.team_ia.data.remote.request.member.MemberRequest
import com.team_ia.data.remote.response.member.MemberResponse
import javax.inject.Inject

class MemberDataSourceImpl @Inject constructor(
    private val memberAPI: MemberAPI
) : MemberDataSource {

    override suspend fun profileInfo(memberRequest: MemberRequest): MemberResponse {
        return memberAPI.profileInfo(memberRequest)
    }
}