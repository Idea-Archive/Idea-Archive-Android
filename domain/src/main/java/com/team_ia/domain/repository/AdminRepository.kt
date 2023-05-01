package com.team_ia.domain.repository

import com.team_ia.domain.entity.*
import com.team_ia.domain.model.NoticeModel
import com.team_ia.domain.param.*

interface AdminRepository {
    suspend fun postNotice(param: PostNoticeParam)
    suspend fun readNotice(): ReadNoticeEntity
    suspend fun deleteNotice(noticeId: Long)
    suspend fun editNotice(noticeId: Long, param: EditNoticeParam)
    suspend fun detailNotice(noticeId: Long): NoticeModel
}