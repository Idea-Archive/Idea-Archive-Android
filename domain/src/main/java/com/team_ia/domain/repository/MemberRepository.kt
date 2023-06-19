package com.team_ia.domain.repository

import com.team_ia.domain.entity.GetDetailNoticeEntity
import com.team_ia.domain.entity.GetNoticeEntity
import com.team_ia.domain.entity.MemberEntity
import com.team_ia.domain.model.PostModel
import com.team_ia.domain.param.ChangeNickNameParam
import com.team_ia.domain.param.FindPasswordParam
import com.team_ia.domain.param.PasswordParam
import com.team_ia.domain.param.WithdrawalMemberParam

interface MemberRepository {
    suspend fun profileInfo(): MemberEntity
    suspend fun changePassword(param: PasswordParam)
    suspend fun withdrawalMember(param: WithdrawalMemberParam)
    suspend fun findPassword(param: FindPasswordParam)
    suspend fun changeNickName(param: ChangeNickNameParam)
    suspend fun getNotice(): GetNoticeEntity
    suspend fun getDetailNotice(noticeId: Long): GetDetailNoticeEntity
    suspend fun getMyPost(): List<PostModel>
    suspend fun getMyHeartList(): List<PostModel>
}