package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.img.ChangeProfilePictureRequest
import com.team_ia.data.remote.request.img.PostProfilePictureRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST

interface ImgAPI {

    @POST("/image")
    suspend fun postProfilePicture(
        @Body postProfilePictureRequest: PostProfilePictureRequest
    ): Response<Unit>

    @PATCH("/image")
    suspend fun changeProfilePicture(
        @Body changeProfilePictureRequest: ChangeProfilePictureRequest
    ): Response<Unit>
}