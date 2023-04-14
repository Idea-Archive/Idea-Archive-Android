package com.team_ia.data.remote.datasource.member

import com.team_ia.data.remote.api.MemberAPI
import com.team_ia.data.remote.request.member.ChangePasswordRequest
import com.team_ia.data.remote.response.member.MemberResponse
import com.team_ia.data.utils.IAApiHandler
import javax.inject.Inject

class MemberDataSourceImpl @Inject constructor(
    private val memberAPI: MemberAPI
) : MemberDataSource {

    override suspend fun profileInfo(): MemberResponse {
        return IAApiHandler<MemberResponse>()
            .httpRequest { memberAPI.profileInfo() }
            .sendRequest()
    }

    override suspend fun changePassword(changePasswordRequest: ChangePasswordRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { memberAPI.changePassword(changePasswordRequest) }
            .sendRequest()
    }

}