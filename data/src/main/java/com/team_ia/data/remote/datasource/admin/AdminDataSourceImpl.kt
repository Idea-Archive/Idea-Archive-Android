package com.team_ia.data.remote.datasource.admin

import com.team_ia.data.remote.api.AdminAPI
import com.team_ia.data.remote.datasource.admin.AdminDataSource
import com.team_ia.data.remote.request.admin.EditNoticeRequest
import com.team_ia.data.remote.request.admin.PostNoticeRequest
import com.team_ia.data.remote.response.admin.ReadNoticeResponse
import com.team_ia.data.utils.IAApiHandler
import javax.inject.Inject

class AdminDataSourceImpl @Inject constructor(
    private val adminAPI: AdminAPI
) : AdminDataSource {

    override suspend fun postNotice(postNoticeRequest: PostNoticeRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { adminAPI.postNotice(postNoticeRequest) }
            .sendRequest()
    }

    override suspend fun readNotice(): ReadNoticeResponse {
        return IAApiHandler<ReadNoticeResponse>()
            .httpRequest { adminAPI.readNotice() }
            .sendRequest()
    }

    override suspend fun deleteNotice(noticeId: Long) {
        return IAApiHandler<Unit>()
            .httpRequest { adminAPI.deleteNotice(noticeId) }
            .sendRequest()
    }

    override suspend fun editNotice(noticeId: Long, editNoticeRequest: EditNoticeRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { adminAPI.editNotice(noticeId, editNoticeRequest) }
            .sendRequest()
    }
}