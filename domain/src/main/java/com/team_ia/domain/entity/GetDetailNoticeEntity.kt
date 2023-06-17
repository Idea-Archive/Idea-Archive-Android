package com.team_ia.domain.entity

data class GetDetailNoticeEntity(
    val noticeId: Long,
    val title: String,
    val content: String,
    val createData: String
)