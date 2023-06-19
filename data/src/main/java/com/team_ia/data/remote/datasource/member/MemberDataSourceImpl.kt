package com.team_ia.data.remote.datasource.member

import com.team_ia.data.remote.api.MemberAPI
import com.team_ia.data.remote.model.PostModel
import com.team_ia.data.remote.request.member.ChangeNickNameRequest
import com.team_ia.data.remote.request.member.ChangePasswordRequest
import com.team_ia.data.remote.request.member.FindPasswordRequest
import com.team_ia.data.remote.request.member.WithdrawalMemberRequest
import com.team_ia.data.remote.response.member.GetDetailNoticeResponse
import com.team_ia.data.remote.response.member.GetNoticeResponse
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

    override suspend fun withdrawalMember(withdrawalMemberRequest: WithdrawalMemberRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { memberAPI.withdrawalMember(withdrawalMemberRequest) }
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

    override suspend fun getNotice(): GetNoticeResponse {
        return IAApiHandler<GetNoticeResponse>()
            .httpRequest { memberAPI.getNotice() }
            .sendRequest()
    }

    override suspend fun getDetailNotice(noticeId: Long): GetDetailNoticeResponse {
        return IAApiHandler<GetDetailNoticeResponse>()
            .httpRequest { memberAPI.getDetailNotice(noticeId) }
            .sendRequest()
    }

    override suspend fun getMyPost(): List<PostModel> {
        return IAApiHandler<List<PostModel>>()
            .httpRequest { memberAPI.getMyPost() }
            .sendRequest()
    }

    override suspend fun getMyHeartList(): List<PostModel> {
        return IAApiHandler<List<PostModel>>()
            .httpRequest { memberAPI.getMyHeartList() }
            .sendRequest()
    }
}