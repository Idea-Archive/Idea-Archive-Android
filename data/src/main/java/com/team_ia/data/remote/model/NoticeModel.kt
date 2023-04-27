package com.team_ia.data.remote.model

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.model.NoticeModel as DomainNoticeModel

data class NoticeModel(
    @SerializedName("noticeId")
    val noticeId: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("createData")
    val createData: String
)

fun NoticeModel.toEntity() = DomainNoticeModel(
    noticeId = noticeId,
    title = title,
    content = content,
    createData = createData
)