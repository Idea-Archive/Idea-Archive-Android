package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.post.WritePostRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PostAPI {

    @POST("/post/write")
    suspend fun writePost(
        @Body writePostRequest: WritePostRequest
    ): Response<Unit>
}