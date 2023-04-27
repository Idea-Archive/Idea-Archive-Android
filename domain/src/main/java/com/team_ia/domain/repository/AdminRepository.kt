package com.team_ia.domain.repository

import com.team_ia.domain.entity.ReadNoticeEntity
import com.team_ia.domain.param.PostNoticeParam

interface AdminRepository {
    suspend fun postNotice(param: PostNoticeParam)
    suspend fun readNotice(): ReadNoticeEntity
}