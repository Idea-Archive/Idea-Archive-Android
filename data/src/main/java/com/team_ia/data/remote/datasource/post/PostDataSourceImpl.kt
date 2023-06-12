package com.team_ia.data.remote.datasource.post

import com.team_ia.data.remote.api.PostAPI
import com.team_ia.data.remote.model.PostModel
import com.team_ia.data.remote.request.post.WritePostRequest
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
}