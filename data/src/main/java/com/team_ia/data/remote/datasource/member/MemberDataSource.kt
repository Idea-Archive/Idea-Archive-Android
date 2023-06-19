package com.team_ia.data.remote.datasource.member

import com.team_ia.data.remote.model.PostModel
import com.team_ia.data.remote.request.member.ChangeNickNameRequest
import com.team_ia.data.remote.request.member.ChangePasswordRequest
import com.team_ia.data.remote.request.member.FindPasswordRequest
import com.team_ia.data.remote.request.member.WithdrawalMemberRequest
import com.team_ia.data.remote.response.member.GetDetailNoticeResponse
import com.team_ia.data.remote.response.member.GetNoticeResponse
import com.team_ia.data.remote.response.member.MemberResponse

interface MemberDataSource {
    suspend fun profileInfo(): MemberResponse
    suspend fun changePassword(changePasswordRequest: ChangePasswordRequest)
    suspend fun withdrawalMember(withdrawalMemberRequest: WithdrawalMemberRequest)
    suspend fun findPassword(findPasswordRequest: FindPasswordRequest)
    suspend fun changeNickName(changeNickNameRequest: ChangeNickNameRequest)
    suspend fun getNotice(): GetNoticeResponse
    suspend fun getDetailNotice(noticeId: Long): GetDetailNoticeResponse
    suspend fun getMyPost(): List<PostModel>
    suspend fun getMyHeartList(): List<PostModel>
}