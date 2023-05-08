package com.team_ia.domain.repository

import com.team_ia.domain.param.ChangeProfilePictureParam
import com.team_ia.domain.param.PostProfilePictureParam

interface ImgRepository {
    suspend fun postProfilePicture(postProfilePictureParam: PostProfilePictureParam)
    suspend fun changeProfilePicture(changeProfilePictureParam: ChangeProfilePictureParam)
    suspend fun deleteProfilePicture()
}