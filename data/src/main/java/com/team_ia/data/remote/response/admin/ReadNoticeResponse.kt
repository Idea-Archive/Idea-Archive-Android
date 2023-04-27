package com.team_ia.data.remote.response.admin

import com.google.gson.annotations.SerializedName
import com.team_ia.data.remote.model.NoticeModel
import com.team_ia.data.remote.model.toEntity
import com.team_ia.domain.entity.ReadNoticeEntity

data class ReadNoticeResponse(
    @SerializedName("noticeResponses")
    val notice: List<NoticeModel>
)

fun ReadNoticeResponse.toEntity() = ReadNoticeEntity(
    notice = notice.map { it.toEntity() }
)
