package com.team_ia.data.remote.datasource.admin

import com.team_ia.data.remote.request.admin.PostNoticeRequest

interface AdminDataSource {
    suspend fun postNotice(postNoticeRequest: PostNoticeRequest)
}