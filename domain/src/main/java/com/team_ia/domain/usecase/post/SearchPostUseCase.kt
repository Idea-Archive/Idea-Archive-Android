package com.team_ia.domain.usecase.post

import com.team_ia.domain.param.SearchPostParam
import com.team_ia.domain.repository.PostRepository
import javax.inject.Inject

class SearchPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(keyword: String, searchPostParam: SearchPostParam) = kotlin.runCatching {
        postRepository.searchPost(keyword, searchPostParam)
    }

}