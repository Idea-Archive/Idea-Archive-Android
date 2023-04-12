package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.member.MemberDataSource
import com.team_ia.data.remote.request.member.toRequest
import com.team_ia.data.remote.response.member.toEntity
import com.team_ia.domain.entity.MemberEntity
import com.team_ia.domain.param.MemberParam
import com.team_ia.domain.repository.MemberRepository
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(
    private val memberDataSource: MemberDataSource
) : MemberRepository {

    override suspend fun profileInfo(memberParam: MemberParam): MemberEntity =
        memberDataSource.profileInfo(memberParam.toRequest()).toEntity()

}