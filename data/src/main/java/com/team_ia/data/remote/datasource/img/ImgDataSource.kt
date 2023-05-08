package com.team_ia.data.remote.datasource.img

import com.team_ia.data.remote.request.img.ChangeProfilePictureRequest
import com.team_ia.data.remote.request.img.PostProfilePictureRequest

interface ImgDataSource {
    suspend fun postProfilePicture(postProfilePictureRequest: PostProfilePictureRequest)
    suspend fun changeProfilePicture(changeProfilePictureRequest: ChangeProfilePictureRequest)
    suspend fun deleteProfilePicture()
}