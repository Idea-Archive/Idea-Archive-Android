package com.team_ia.domain.repository

import com.team_ia.domain.param.PostProfilePictureParam

interface ImgRepository {
    suspend fun postProfilePicture(postProfilePictureParam: PostProfilePictureParam)
}