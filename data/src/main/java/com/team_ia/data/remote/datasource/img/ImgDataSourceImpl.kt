package com.team_ia.data.remote.datasource.img

import com.team_ia.data.remote.api.ImgAPI
import com.team_ia.data.remote.request.img.ChangeProfilePictureRequest
import com.team_ia.data.remote.request.img.PostProfilePictureRequest
import com.team_ia.data.utils.IAApiHandler
import javax.inject.Inject

class ImgDataSourceImpl @Inject constructor(
    private val imgAPI: ImgAPI
) : ImgDataSource {

    override suspend fun postProfilePicture(postProfilePictureRequest: PostProfilePictureRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { imgAPI.postProfilePicture(postProfilePictureRequest) }
            .sendRequest()
    }

    override suspend fun changeProfilePicture(changeProfilePictureRequest: ChangeProfilePictureRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { imgAPI.changeProfilePicture(changeProfilePictureRequest) }
            .sendRequest()
    }

    override suspend fun deleteProfilePicture() {
        return IAApiHandler<Unit>()
            .httpRequest { imgAPI.deleteProfilePicture() }
            .sendRequest()
    }

}