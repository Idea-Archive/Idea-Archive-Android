package com.team_ia.domain.usecase.post

import com.team_ia.domain.repository.PostRepository
import javax.inject.Inject

class GetPopularPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke() = kotlin.runCatching {
        postRepository.getPopularPost()
    }

}