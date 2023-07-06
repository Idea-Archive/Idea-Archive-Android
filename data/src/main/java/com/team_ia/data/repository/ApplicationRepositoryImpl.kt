package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.application.ApplicationDataSource
import com.team_ia.data.remote.response.application.toEntity
import com.team_ia.domain.entity.GetApplicantEntity
import com.team_ia.domain.repository.ApplicationRepository
import javax.inject.Inject

class ApplicationRepositoryImpl @Inject constructor(
    private val applicationDataSource: ApplicationDataSource
) : ApplicationRepository {

    override suspend fun applicationPost(postId: Long) =
        applicationDataSource.applicationPost(postId)

    override suspend fun getApplicant(postId: Long): GetApplicantEntity =
        applicationDataSource.getApplicant(postId).toEntity()

}