package com.team_ia.data.remote.api

import com.team_ia.data.remote.model.PostModel
import com.team_ia.data.remote.request.post.SearchPostRequest
import com.team_ia.data.remote.request.post.WritePostRequest
import com.team_ia.data.remote.response.post.GetDetailPostResponse
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
    ): GetDetailPostResponse

    @PATCH("/post/{postId}")
    suspend fun editPost(
        @Path("postId") postId: Long,
        @Body editPostRequest: WritePostRequest
    )

    @DELETE("/post/{postId}")
    suspend fun deletePost(
        @Path("postId") postId: Long
    )

    @POST("/post/search")
    suspend fun searchPost(
        @Query("keyword") keyword: String,
        @Body searchPostRequest: SearchPostRequest
    ): List<PostModel>

    @GET("/post/popular")
    suspend fun getPopularPost(): List<PostModel>

    @POST("/post/category")
    suspend fun getCategoryPost(
        @Body getCategoryPostRequest: SearchPostRequest
    ): List<PostModel>
}