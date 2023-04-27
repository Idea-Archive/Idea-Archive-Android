package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.admin.PostNoticeRequest
import com.team_ia.data.remote.response.admin.ReadNoticeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AdminAPI {

    @POST("/admin/notice/write")
    suspend fun postNotice(
        @Body postNoticeRequest: PostNoticeRequest
    ): Response<Unit>

    @GET("/admin/notice")
    suspend fun readNotice(): ReadNoticeResponse
}