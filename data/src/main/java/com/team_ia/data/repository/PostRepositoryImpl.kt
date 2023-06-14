package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.post.PostDataSource
import com.team_ia.data.remote.model.toEntity
import com.team_ia.data.remote.request.post.toRequest
import com.team_ia.data.remote.response.post.toEntity
import com.team_ia.domain.entity.GetDetailPostEntity
import com.team_ia.domain.model.PostModel
import com.team_ia.domain.param.PostCommentParam
import com.team_ia.domain.param.SearchPostParam
import com.team_ia.domain.param.WritePostParam
import com.team_ia.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postDataSource: PostDataSource
): PostRepository {
    override suspend fun writePost(param: WritePostParam) =
        postDataSource.writePost(param.toRequest())

    override suspend fun getPost(): List<PostModel> =
        postDataSource.getPost().map { it.toEntity() }

    override suspend fun getDetailPost(postId: Long): GetDetailPostEntity =
        postDataSource.getDetailPost(postId).toEntity()

    override suspend fun editPost(postId: Long, param: WritePostParam) =
        postDataSource.editPost(postId, param.toRequest())

    override suspend fun deletePost(postId: Long) =
        postDataSource.deletePost(postId)

    override suspend fun searchPost(keyword: String, param: SearchPostParam): List<PostModel> =
        postDataSource.searchPost(keyword, param.toRequest()).map { it.toEntity() }

    override suspend fun getPopularPost(): List<PostModel> =
        postDataSource.getPopularPost().map { it.toEntity() }

    override suspend fun getCategoryPost(param: SearchPostParam): List<PostModel> =
        postDataSource.getCategoryPost(param.toRequest()).map { it.toEntity() }

    override suspend fun postHeart(postId: Long) =
        postDataSource.postHeart(postId)

    override suspend fun postComment(postId: Long, param: PostCommentParam) =
        postDataSource.postComment(postId, param.toRequest())

    override suspend fun editComment(commentId: Long, param: PostCommentParam) =
        postDataSource.editComment(commentId, param.toRequest())
}