package com.team_ia.data.remote.datasource.member

import com.team_ia.data.remote.api.MemberAPI
import com.team_ia.data.remote.request.member.ChangePasswordRequest
import com.team_ia.data.remote.request.member.MemberRequest
import com.team_ia.data.remote.response.member.MemberResponse
import com.team_ia.data.utils.IAApiHandler
import retrofit2.Response
import javax.inject.Inject

class MemberDataSourceImpl @Inject constructor(
    private val memberAPI: MemberAPI
) : MemberDataSource {

    override suspend fun profileInfo(): MemberResponse {
        return IAApiHandler<MemberResponse>()
            .httpRequest { memberAPI.profileInfo() }
            .sendRequest()
    }

    override suspend fun changePassword(body: ChangePasswordRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { memberAPI.changePassword(body) }
            .sendRequest()
    }

}