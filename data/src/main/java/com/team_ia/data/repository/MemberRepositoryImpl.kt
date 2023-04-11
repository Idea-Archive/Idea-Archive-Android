package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.member.MemberDataSource
import com.team_ia.domain.repository.MemberRepository
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(
    private val memberDataSource: MemberDataSource
) : MemberRepository {
}