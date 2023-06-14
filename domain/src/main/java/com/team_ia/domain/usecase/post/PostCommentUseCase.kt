package com.team_ia.domain.usecase.post

import com.team_ia.domain.param.PostCommentParam
import com.team_ia.domain.repository.PostRepository
import javax.inject.Inject

class PostCommentUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(postId: Long, postCommentParam: PostCommentParam) = kotlin.runCatching {
        postRepository.postComment(postId, postCommentParam)
    }
}