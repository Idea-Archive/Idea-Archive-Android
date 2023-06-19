package com.team_ia.data.remote.response.member

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.entity.GetDetailNoticeEntity

data class GetDetailNoticeResponse(
    @SerializedName("noticeId")
    val noticeId: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("createDate")
    val createDate: String
)
 fun GetDetailNoticeResponse.toEntity() = GetDetailNoticeEntity(
     noticeId = noticeId,
     title = title,
     content = content,
     createDate = createDate
 )