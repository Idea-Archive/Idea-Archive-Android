package com.team_ia.data.remote.datasource.post

import com.team_ia.data.remote.api.PostAPI
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(
    private val postApi: PostAPI
): PostDataSource {
}