package com.team_ia.data.remote.datasource.application

import com.team_ia.data.remote.response.application.GetApplicantResponse

interface ApplicationDataSource {
    suspend fun applicationPost(postId: Long)
    suspend fun getApplicant(postId: Long): GetApplicantResponse
}