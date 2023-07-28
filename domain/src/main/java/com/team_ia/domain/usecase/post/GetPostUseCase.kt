package com.team_ia.domain.usecase.post

import com.team_ia.domain.model.PostModel
import com.team_ia.domain.repository.PostRepository
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(): Result<List<PostModel>> = kotlin.runCatching {
        postRepository.getPost()
    }

}