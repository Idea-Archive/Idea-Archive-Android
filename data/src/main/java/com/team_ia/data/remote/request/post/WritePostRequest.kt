package com.team_ia.data.remote.request.post

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.WritePostParam

data class WritePostRequest (
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("category")
    val category: List<String>
)

fun WritePostParam.toRequest() = WritePostRequest(
    title = title,
    content = content,
    category = category
)