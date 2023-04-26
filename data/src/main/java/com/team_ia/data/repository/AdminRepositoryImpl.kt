package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.admin.AdminDataSource
import com.team_ia.data.remote.request.admin.toRequest
import com.team_ia.data.remote.response.admin.toEntity
import com.team_ia.domain.entity.ReadNoticeEntity
import com.team_ia.domain.param.PostNoticeParam
import com.team_ia.domain.repository.AdminRepository
import javax.inject.Inject

class AdminRepositoryImpl @Inject constructor(
    private val adminDataSource: AdminDataSource
) : AdminRepository {

    override suspend fun postNotice(param: PostNoticeParam) =
        adminDataSource.postNotice(param.toRequest())

    override suspend fun readNotice(): ReadNoticeEntity =
        adminDataSource.readNotice().toEntity()

}