package com.team_ia.data.remote.datasource.member

import com.team_ia.data.remote.api.MemberAPI
import javax.inject.Inject

class MemberDataSourceImpl @Inject constructor(
    private val memberAPI: MemberAPI
) : MemberDataSource {
}