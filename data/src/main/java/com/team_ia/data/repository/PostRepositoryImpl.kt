package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.post.PostDataSource
import com.team_ia.data.remote.model.toEntity
import com.team_ia.data.remote.request.post.toRequest
import com.team_ia.domain.model.PostModel
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

    override suspend fun getDetailPost(postId: Long): PostModel =
        postDataSource.getDetailPost(postId).toEntity()

    override suspend fun editPost(postId: Long, param: WritePostParam) =
        postDataSource.editPost(postId, param.toRequest())

    override suspend fun deletePost(postId: Long) =
        postDataSource.deletePost(postId)

    override suspend fun searchPost(keyword: String, param: SearchPostParam): List<PostModel> =
        postDataSource.searchPost(keyword, param.toRequest()).map { it.toEntity() }
}