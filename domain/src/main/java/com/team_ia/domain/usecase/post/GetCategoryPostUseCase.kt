package com.team_ia.domain.usecase.post

import com.team_ia.domain.param.SearchPostParam
import com.team_ia.domain.repository.PostRepository
import javax.inject.Inject

class GetCategoryPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(getCategoryPostParam: SearchPostParam) = kotlin.runCatching {
        postRepository.getCategoryPost(getCategoryPostParam)
    }

}