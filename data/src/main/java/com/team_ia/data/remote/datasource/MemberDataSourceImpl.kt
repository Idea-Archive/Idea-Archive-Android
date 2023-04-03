package com.team_ia.data.remote.datasource

import com.team_ia.data.remote.api.MemberAPI
import javax.inject.Inject

class MemberDataSourceImpl @Inject constructor(
    private val memberApi: MemberAPI
) : MemberDataSource {
}