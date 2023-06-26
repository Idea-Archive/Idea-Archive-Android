package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.member.MemberDataSource
import com.team_ia.data.remote.model.toEntity
import com.team_ia.data.remote.request.member.toRequest
import com.team_ia.data.remote.response.member.toEntity
import com.team_ia.domain.entity.GetDetailNoticeEntity
import com.team_ia.domain.entity.GetNoticeEntity
import com.team_ia.domain.entity.MemberEntity
import com.team_ia.domain.model.PostModel
import com.team_ia.domain.param.ChangeNickNameParam
import com.team_ia.domain.param.FindPasswordParam
import com.team_ia.domain.param.PasswordParam
import com.team_ia.domain.param.WithdrawalMemberParam
import com.team_ia.domain.repository.MemberRepository
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(
    private val memberDataSource: MemberDataSource
) : MemberRepository {

    override suspend fun getProfileInfo(): MemberEntity =
        memberDataSource.getProfileInfo().toEntity()

    override suspend fun changePassword(param: PasswordParam) =
        memberDataSource.changePassword(param.toRequest())

    override suspend fun withdrawalMember(param: WithdrawalMemberParam) =
        memberDataSource.withdrawalMember(param.toRequest())

    override suspend fun findPassword(param: FindPasswordParam) =
        memberDataSource.findPassword(param.toRequest())

    override suspend fun changeNickName(param: ChangeNickNameParam) =
        memberDataSource.changeNickName(param.toRequest())

    override suspend fun getNotice(): GetNoticeEntity =
        memberDataSource.getNotice().toEntity()

    override suspend fun getDetailNotice(noticeId: Long): GetDetailNoticeEntity =
        memberDataSource.getDetailNotice(noticeId).toEntity()

    override suspend fun getMyPost(): List<PostModel> =
        memberDataSource.getMyPost().map { it.toEntity() }

    override suspend fun getMyHeartList(): List<PostModel> =
        memberDataSource.getMyHeartList().map { it.toEntity() }
}