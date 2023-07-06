package com.team_ia.domain.usecase.post

import com.team_ia.domain.repository.PostRepository
import javax.inject.Inject

class DeleteCommentUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(commentId: Long) = kotlin.runCatching {
        postRepository.deleteComment(commentId)
    }

}