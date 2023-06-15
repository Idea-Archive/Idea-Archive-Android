package com.team_ia.domain.repository

import com.team_ia.domain.entity.GetDetailPostEntity
import com.team_ia.domain.model.PostModel
import com.team_ia.domain.param.PostCommentParam
import com.team_ia.domain.param.SearchPostParam
import com.team_ia.domain.param.WritePostParam

interface PostRepository {
    suspend fun writePost(param: WritePostParam)
    suspend fun getPost(): List<PostModel>
    suspend fun getDetailPost(postId: Long): GetDetailPostEntity
    suspend fun editPost(postId: Long, param: WritePostParam)
    suspend fun deletePost(postId: Long)
    suspend fun searchPost(keyword: String, param: SearchPostParam): List<PostModel>
    suspend fun getPopularPost(): List<PostModel>
    suspend fun getCategoryPost(param: SearchPostParam): List<PostModel>
    suspend fun postHeart(postId: Long)
    suspend fun postComment(postId: Long, param: PostCommentParam)
    suspend fun editComment(commentId: Long, param: PostCommentParam)
    suspend fun deleteComment(commentId: Long)
}