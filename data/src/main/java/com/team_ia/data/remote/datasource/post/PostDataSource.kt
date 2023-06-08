package com.team_ia.data.remote.datasource.post

import com.team_ia.data.remote.request.post.WritePostRequest

interface PostDataSource {
    suspend fun writePost(writePostRequest: WritePostRequest)
}