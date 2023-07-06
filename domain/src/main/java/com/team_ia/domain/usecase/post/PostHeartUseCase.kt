package com.team_ia.domain.usecase.post

import com.team_ia.domain.repository.PostRepository
import javax.inject.Inject

class PostHeartUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(postId: Long) = kotlin.runCatching {
        postRepository.postHeart(postId)
    }

}