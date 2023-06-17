package com.team_ia.data.remote.response.member

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.entity.GetNoticeEntity
import com.team_ia.domain.entity.GetNoticeEntity.Notice as DomainNotice

data class GetNoticeResponse(
    @SerializedName("noticeResponses")
    val noticeResponses: List<Notice>
){
    data class Notice(
        @SerializedName("noticeId")
        val noticeId: Long,
        @SerializedName("title")
        val title: String,
        @SerializedName("content")
        val content: String,
        @SerializedName("createData")
        val createData: String
    )

    fun Notice.toEntity() = DomainNotice(
        noticeId = noticeId,
        title = title,
        content = content,
        createData = createData
    )
}

fun GetNoticeResponse.toEntity() = GetNoticeEntity(
    noticeResponses = noticeResponses.map { it.toEntity() }
)