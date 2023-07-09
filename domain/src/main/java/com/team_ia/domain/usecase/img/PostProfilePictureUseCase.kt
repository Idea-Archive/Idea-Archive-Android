package com.team_ia.domain.usecase.img

import com.team_ia.domain.param.PostProfilePictureParam
import com.team_ia.domain.repository.ImgRepository
import javax.inject.Inject

class PostProfilePictureUseCase @Inject constructor(
    private val imgRepository: ImgRepository
) {
    suspend operator fun invoke(postProfilePictureParam: PostProfilePictureParam) = kotlin.runCatching {
        imgRepository.postProfilePicture(postProfilePictureParam)
    }

}