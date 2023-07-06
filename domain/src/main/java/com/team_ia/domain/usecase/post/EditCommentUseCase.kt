package com.team_ia.domain.usecase.post

import com.team_ia.domain.param.PostCommentParam
import com.team_ia.domain.repository.PostRepository
import javax.inject.Inject

class EditCommentUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(commentId: Long, editCommentParam: PostCommentParam) = kotlin.runCatching {
        postRepository.editComment(commentId, editCommentParam)
    }

}