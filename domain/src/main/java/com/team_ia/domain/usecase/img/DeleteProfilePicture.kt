package com.team_ia.domain.usecase.img

import com.team_ia.domain.repository.ImgRepository
import javax.inject.Inject

class DeleteProfilePicture @Inject constructor(
    private val imgRepository: ImgRepository
) {
    suspend operator fun invoke() = kotlin.runCatching {
        imgRepository.deleteProfilePicture()
    }

}