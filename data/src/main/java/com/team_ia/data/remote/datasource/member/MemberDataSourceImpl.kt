package com.team_ia.data.remote.datasource.member

import com.team_ia.data.remote.api.MemberAPI
import com.team_ia.data.remote.request.member.ChangeNickNameRequest
import com.team_ia.data.remote.request.member.ChangePasswordRequest
import com.team_ia.data.remote.request.member.FindPasswordRequest
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

    override suspend fun withdrawalMember(email: String, password: String) {
        return IAApiHandler<Unit>()
            .httpRequest { memberAPI.withdrawalMember(email = email, password = password) }
            .sendRequest()
    }

    override suspend fun findPassword(findPasswordRequest: FindPasswordRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { memberAPI.findPassword(findPasswordRequest) }
            .sendRequest()
    }

    override suspend fun changeNickName(changeNickNameRequest: ChangeNickNameRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { memberAPI.changeNickName(changeNickNameRequest) }
            .sendRequest()
    }
}