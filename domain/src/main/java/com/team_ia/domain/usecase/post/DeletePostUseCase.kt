package com.team_ia.domain.usecase.post

import com.team_ia.domain.repository.PostRepository
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(postId: Long) = kotlin.runCatching {
        postRepository.deletePost(postId)
    }
}