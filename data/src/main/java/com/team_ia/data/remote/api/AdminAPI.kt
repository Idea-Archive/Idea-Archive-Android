package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.admin.EditNoticeRequest
import com.team_ia.data.remote.request.admin.PostNoticeRequest
import com.team_ia.data.remote.response.admin.ReadNoticeResponse
import retrofit2.Response
import retrofit2.http.*

interface AdminAPI {

    @POST("/admin/notice/write")
    suspend fun postNotice(
        @Body postNoticeRequest: PostNoticeRequest
    ): Response<Unit>

    @GET("/admin/notice")
    suspend fun readNotice(): ReadNoticeResponse

    @DELETE("/admin/notice/{noticeId}")
    suspend fun deleteNotice(
        @Path("noticeId") noticeId: Long
    ): Response<Unit>

    @PATCH("/admin/notice/{noticeId}")
    suspend fun editNotice(
        @Path("noticeId") noticeId: Long,
        @Body editNoticeRequest: EditNoticeRequest
    ): Response<Unit>
}