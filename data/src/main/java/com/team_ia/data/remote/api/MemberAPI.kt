package com.team_ia.data.remote.api

import com.team_ia.data.remote.model.PostModel
import com.team_ia.data.remote.request.member.*
import com.team_ia.data.remote.response.member.GetDetailNoticeResponse
import com.team_ia.data.remote.response.member.GetNoticeResponse
import com.team_ia.data.remote.response.member.MemberResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface MemberAPI {

    @GET("/member")
    suspend fun profileInfo(): MemberResponse

    @PATCH("/member")
    suspend fun changePassword(
        @Body changePasswordRequest: ChangePasswordRequest
    ): Response<Unit>

    @DELETE
    suspend fun withdrawalMember(
        @Body withdrawalMemberRequest: WithdrawalMemberRequest
    ): Response<Unit>

    @PATCH("/member/findpw")
    suspend fun findPassword(
        @Body findPasswordRequest: FindPasswordRequest
    ): Response<Unit>

    @PATCH("/member/name")
    suspend fun changeNickName(
        @Body changeNickNameRequest: ChangeNickNameRequest
    ): Response<Unit>

    @GET("/member/notice")
    suspend fun getNotice(): GetNoticeResponse

    @GET("/member/notice/{noticeId}")
    suspend fun getDetailNotice(
        @Path("noticeId") noticeId: Long
    ): GetDetailNoticeResponse

    @GET("/member/my-post")
    suspend fun getMyPost(): List<PostModel>

    @GET("/member/my-heartList")
    suspend fun getMyHeartList(): List<PostModel>
}