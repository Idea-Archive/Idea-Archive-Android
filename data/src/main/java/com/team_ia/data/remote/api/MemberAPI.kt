package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.member.MemberRequest
import com.team_ia.data.remote.response.member.MemberResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface MemberAPI {

    @GET("/member")
    suspend fun profileInfo(
        @Body memberRequest: MemberRequest
    ): MemberResponse
}