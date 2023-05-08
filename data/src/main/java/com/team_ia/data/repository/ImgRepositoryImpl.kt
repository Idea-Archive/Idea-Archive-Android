package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.img.ImgDataSource
import com.team_ia.data.remote.request.img.toRequest
import com.team_ia.domain.param.ChangeProfilePictureParam
import com.team_ia.domain.param.PostProfilePictureParam
import com.team_ia.domain.repository.ImgRepository
import javax.inject.Inject

class ImgRepositoryImpl @Inject constructor(
    private val imgDataSource: ImgDataSource
) : ImgRepository {

    override suspend fun postProfilePicture(postProfilePictureParam: PostProfilePictureParam) =
        imgDataSource.postProfilePicture(postProfilePictureParam.toRequest())

    override suspend fun changeProfilePicture(changeProfilePictureParam: ChangeProfilePictureParam) =
        imgDataSource.changeProfilePicture(changeProfilePictureParam.toRequest())
}