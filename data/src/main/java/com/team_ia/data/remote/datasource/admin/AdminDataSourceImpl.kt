package com.team_ia.data.remote.datasource.admin

import com.team_ia.data.remote.api.AdminAPI
import com.team_ia.data.remote.datasource.admin.AdminDataSource
import com.team_ia.data.remote.request.admin.PostNoticeRequest
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
}