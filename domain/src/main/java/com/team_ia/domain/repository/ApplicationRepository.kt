package com.team_ia.domain.repository

import com.team_ia.domain.entity.GetApplicantEntity

interface ApplicationRepository {
    suspend fun applicationPost(postId: Long)
    suspend fun getApplicant(postId: Long): GetApplicantEntity
}