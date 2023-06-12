package com.team_ia.domain.repository

import com.team_ia.domain.model.PostModel
import com.team_ia.domain.param.SearchPostParam
import com.team_ia.domain.param.WritePostParam

interface PostRepository {
    suspend fun writePost(param: WritePostParam)
    suspend fun getPost(): List<PostModel>
    suspend fun getDetailPost(postId: Long): PostModel
    suspend fun editPost(postId: Long, param: WritePostParam)
    suspend fun deletePost(postId: Long)
    suspend fun searchPost(keyword: String, param: SearchPostParam): List<PostModel>
}