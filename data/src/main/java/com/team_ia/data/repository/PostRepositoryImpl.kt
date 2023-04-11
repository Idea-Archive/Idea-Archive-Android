package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.post.PostDataSource
import com.team_ia.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postDataSource: PostDataSource
): PostRepository {
}