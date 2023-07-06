package com.team_ia.data.remote.datasource.post

import com.team_ia.data.remote.api.PostAPI
import com.team_ia.data.remote.model.PostModel
import com.team_ia.data.remote.request.post.PostCommentRequest
import com.team_ia.data.remote.request.post.SearchPostRequest
import com.team_ia.data.remote.request.post.WritePostRequest
import com.team_ia.data.remote.response.post.GetDetailPostResponse
import com.team_ia.data.utils.IAApiHandler
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(
    private val postApi: PostAPI
): PostDataSource {
    override suspend fun writePost(writePostRequest: WritePostRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { postApi.writePost(writePostRequest) }
            .sendRequest()
    }

    override suspend fun getPost(): List<PostModel> {
        return IAApiHandler<List<PostModel>>()
            .httpRequest { postApi.getPost() }
            .sendRequest()
    }

    override suspend fun getDetailPost(postId: Long): GetDetailPostResponse {
        return IAApiHandler<GetDetailPostResponse>()
            .httpRequest { postApi.getDetailPost(postId) }
            .sendRequest()
    }

    override suspend fun editPost(postId: Long, editPostRequest: WritePostRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { postApi.editPost(postId, editPostRequest) }
            .sendRequest()
    }

    override suspend fun deletePost(postId: Long) {
        return IAApiHandler<Unit>()
            .httpRequest { postApi.deletePost(postId) }
            .sendRequest()
    }

    override suspend fun searchPost(keyword: String, searchPostRequest: SearchPostRequest
    ): List<PostModel> {
        return IAApiHandler<List<PostModel>>()
            .httpRequest { postApi.searchPost(keyword, searchPostRequest) }
            .sendRequest()
    }

    override suspend fun getPopularPost(): List<PostModel> {
        return IAApiHandler<List<PostModel>>()
            .httpRequest { postApi.getPopularPost() }
            .sendRequest()
    }

    override suspend fun getCategoryPost(getCategoryPostRequest: SearchPostRequest): List<PostModel> {
        return IAApiHandler<List<PostModel>>()
            .httpRequest { postApi.getCategoryPost(getCategoryPostRequest) }
            .sendRequest()
    }

    override suspend fun postHeart(postId: Long) {
        return IAApiHandler<Unit>()
            .httpRequest { postApi.postHeart(postId) }
            .sendRequest()
    }

    override suspend fun postComment(postId: Long, postCommentRequest: PostCommentRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { postApi.postComment(postId, postCommentRequest) }
            .sendRequest()
    }

    override suspend fun editComment(commentId: Long, editCommentRequest: PostCommentRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { postApi.editComment(commentId, editCommentRequest) }
            .sendRequest()
    }

    override suspend fun deleteComment(commentId: Long) {
        return IAApiHandler<Unit>()
            .httpRequest { postApi.deleteComment(commentId) }
            .sendRequest()
    }

}