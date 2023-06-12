package com.team_ia.domain.repository

import com.team_ia.domain.model.PostModel
import com.team_ia.domain.param.WritePostParam

interface PostRepository {
    suspend fun writePost(param: WritePostParam)
    suspend fun getPost(): List<PostModel>
}