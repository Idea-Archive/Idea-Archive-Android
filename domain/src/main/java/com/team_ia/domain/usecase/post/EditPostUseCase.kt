package com.team_ia.domain.usecase.post

import com.team_ia.domain.param.WritePostParam
import com.team_ia.domain.repository.PostRepository
import javax.inject.Inject

class EditPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(postId: Long, editPostParam: WritePostParam) = kotlin.runCatching {
        postRepository.editPost(postId, editPostParam)
    }
}