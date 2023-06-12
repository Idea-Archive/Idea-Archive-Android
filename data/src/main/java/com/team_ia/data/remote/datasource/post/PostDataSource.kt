package com.team_ia.data.remote.datasource.post

import com.team_ia.data.remote.model.PostModel
import com.team_ia.data.remote.request.post.WritePostRequest

interface PostDataSource {
    suspend fun writePost(writePostRequest: WritePostRequest)
    suspend fun getPost(): List<PostModel>
    suspend fun getDetailPost(postId: Long): PostModel
    suspend fun editPost(postId: Long, editPostRequest: WritePostRequest)
    suspend fun deletePost(postId: Long)
}