package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.member.ChangePasswordRequest
import com.team_ia.data.remote.request.member.MemberRequest
import com.team_ia.data.remote.response.member.MemberResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH

interface MemberAPI {

    @GET("/member")
    suspend fun profileInfo(): MemberResponse

    @PATCH("/member")
    suspend fun changePassword(
        @Body changePasswordRequest: ChangePasswordRequest
    ): Response<Unit>
}