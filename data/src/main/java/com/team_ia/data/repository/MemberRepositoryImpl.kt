package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.member.MemberDataSource
import com.team_ia.data.remote.request.member.toRequest
import com.team_ia.data.remote.response.member.toEntity
import com.team_ia.domain.entity.MemberEntity
import com.team_ia.domain.param.PasswordParam
import com.team_ia.domain.repository.MemberRepository
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(
    private val memberDataSource: MemberDataSource
) : MemberRepository {

    override suspend fun profileInfo(): MemberEntity =
        memberDataSource.profileInfo().toEntity()

    override suspend fun changePassword(param: PasswordParam) =
        memberDataSource.changePassword(param.toRequest())

    override suspend fun withdrawalMember(email: String, password: String) {
        memberDataSource.withdrawalMember(email = email, password = password)
    }
}