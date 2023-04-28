package com.team_ia.data.remote.request.admin

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.EditNoticeParam

data class EditNoticeRequest (
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String
)

fun EditNoticeParam.toRequest() = EditNoticeRequest(
    title = title,
    content = content
)