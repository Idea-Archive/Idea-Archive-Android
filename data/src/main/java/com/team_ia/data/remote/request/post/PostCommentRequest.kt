package com.team_ia.data.remote.request.post

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.PostCommentParam

data class PostCommentRequest(
    @SerializedName("content")
    val content: String
)

fun PostCommentParam.toRequest() = PostCommentRequest(
    content = content
)