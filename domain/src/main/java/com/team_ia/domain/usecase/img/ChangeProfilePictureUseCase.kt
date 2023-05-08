package com.team_ia.domain.usecase.img

import com.team_ia.domain.param.ChangeProfilePictureParam
import com.team_ia.domain.repository.ImgRepository
import javax.inject.Inject

class ChangeProfilePictureUseCase @Inject constructor(
    private val imgRepository: ImgRepository
) {
    suspend operator fun invoke(changeProfilePictureParam: ChangeProfilePictureParam) = kotlin.runCatching {
        imgRepository.changeProfilePicture(changeProfilePictureParam)
    }
}