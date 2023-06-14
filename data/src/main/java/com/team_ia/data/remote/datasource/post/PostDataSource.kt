package com.team_ia.data.remote.datasource.post

import com.team_ia.data.remote.model.PostModel
import com.team_ia.data.remote.request.post.PostCommentRequest
import com.team_ia.data.remote.request.post.SearchPostRequest
import com.team_ia.data.remote.request.post.WritePostRequest
import com.team_ia.data.remote.response.post.GetDetailPostResponse

interface PostDataSource {
    suspend fun writePost(writePostRequest: WritePostRequest)
    suspend fun getPost(): List<PostModel>
    suspend fun getDetailPost(postId: Long): GetDetailPostResponse
    suspend fun editPost(postId: Long, editPostRequest: WritePostRequest)
    suspend fun deletePost(postId: Long)
    suspend fun searchPost(keyword: String, searchPostRequest: SearchPostRequest): List<PostModel>
    suspend fun getPopularPost(): List<PostModel>
    suspend fun getCategoryPost(getCategoryPostRequest: SearchPostRequest): List<PostModel>
    suspend fun postHeart(postId: Long)
    suspend fun postComment(postId: Long, postCommentRequest: PostCommentRequest)
}