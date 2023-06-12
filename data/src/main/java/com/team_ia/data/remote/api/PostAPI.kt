package com.team_ia.data.remote.api

import com.team_ia.data.remote.model.PostModel
import com.team_ia.data.remote.request.post.WritePostRequest
import retrofit2.Response
import retrofit2.http.*

interface PostAPI {

    @POST("/post/write")
    suspend fun writePost(
        @Body writePostRequest: WritePostRequest
    ): Response<Unit>

    @GET("/post")
    suspend fun getPost(): List<PostModel>

    @GET("/post/{postId}")
    suspend fun getDetailPost(
        @Path("postId") postId: Long
    ): PostModel
}