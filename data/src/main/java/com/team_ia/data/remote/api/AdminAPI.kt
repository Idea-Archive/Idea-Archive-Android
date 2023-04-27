package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.admin.PostNoticeRequest
import com.team_ia.data.remote.response.admin.ReadNoticeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

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
}