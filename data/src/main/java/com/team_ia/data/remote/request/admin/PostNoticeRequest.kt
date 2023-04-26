package com.team_ia.data.remote.request.admin

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.PostNoticeParam

data class PostNoticeRequest(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String
)

fun PostNoticeParam.toRequest() = PostNoticeRequest(
    title = title,
    content = content
)