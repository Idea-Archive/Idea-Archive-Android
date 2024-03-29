package com.team_ia.data.remote.datasource.admin

import com.team_ia.data.remote.model.NoticeModel
import com.team_ia.data.remote.request.admin.EditNoticeRequest
import com.team_ia.data.remote.request.admin.PostNoticeRequest
import com.team_ia.data.remote.response.admin.ReadNoticeResponse

interface AdminDataSource {
    suspend fun postNotice(postNoticeRequest: PostNoticeRequest)
    suspend fun readNotice(): ReadNoticeResponse
    suspend fun deleteNotice(noticeId: Long)
    suspend fun editNotice(noticeId: Long, editNoticeRequest: EditNoticeRequest)
    suspend fun detailNotice(noticeId: Long): NoticeModel
}