package com.team_ia.domain.entity

data class GetNoticeEntity(
    val noticeResponses: List<Notice>
){
    data class Notice(
        val noticeId: Long,
        val title: String,
        val content: String,
        val createDate: String
    )
}
