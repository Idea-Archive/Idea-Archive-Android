package com.team_ia.data.remote.datasource.application

import com.team_ia.data.remote.api.ApplicationAPI
import com.team_ia.data.remote.response.application.GetApplicantResponse
import com.team_ia.data.utils.IAApiHandler
import javax.inject.Inject

class ApplicationDataSourceImpl @Inject constructor(
    private val applicationAPI: ApplicationAPI
) : ApplicationDataSource {

    override suspend fun applicationPost(postId: Long) {
        return IAApiHandler<Unit>()
            .httpRequest { applicationAPI.applicationPost(postId) }
            .sendRequest()
    }

    override suspend fun getApplicant(postId: Long): GetApplicantResponse {
        return IAApiHandler<GetApplicantResponse>()
            .httpRequest { applicationAPI.getApplicant(postId) }
            .sendRequest()
    }

}