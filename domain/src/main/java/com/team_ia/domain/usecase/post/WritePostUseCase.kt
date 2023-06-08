package com.team_ia.domain.usecase.post

import com.team_ia.domain.param.WritePostParam
import com.team_ia.domain.repository.PostRepository
import javax.inject.Inject

class WritePostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(writePostParam: WritePostParam) = kotlin.runCatching {
        postRepository.writePost(writePostParam)
    }
}