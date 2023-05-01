package com.team_ia.domain.repository

interface ApplicationRepository {
    suspend fun applicationPost(postId: Long)
}