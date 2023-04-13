package com.team_ia.data.remote.datasource.member

import com.team_ia.data.remote.request.member.ChangePasswordRequest
import com.team_ia.data.remote.response.member.MemberResponse

interface MemberDataSource {
    suspend fun profileInfo(): MemberResponse
    suspend fun changePassword(changePasswordRequest: ChangePasswordRequest)
}