package com.team_ia.data.remote.datasource.application

interface ApplicationDataSource {
    suspend fun applicationPost(postId: Long)
}