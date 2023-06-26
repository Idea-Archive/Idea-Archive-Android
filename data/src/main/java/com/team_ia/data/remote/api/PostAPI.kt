package com.team_ia.data.remote.api

import com.team_ia.data.remote.model.PostModel
import com.team_ia.data.remote.request.post.PostCommentRequest
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
    ): Response<Unit>

    @DELETE("/post/{postId}")
    suspend fun deletePost(
        @Path("postId") postId: Long
    ): Response<Unit>

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

    @POST("/post/{postId}/heart")
    suspend fun postHeart(
        @Path("postId") postId: Long
    ): Response<Unit>

    @POST("/post/comment/{postId}")
    suspend fun postComment(
        @Path("postId") postId: Long,
        @Body postCommentRequest: PostCommentRequest
    ): Response<Unit>

    @PATCH("/post/comment/{commentId}")
    suspend fun editComment(
        @Path("commentId") commentId: Long,
        @Body editCommentRequest: PostCommentRequest
    ): Response<Unit>

    @DELETE("/post/comment/{commentId}")
    suspend fun deleteComment(
        @Path("commentId") commentId: Long
    ): Response<Unit>
}