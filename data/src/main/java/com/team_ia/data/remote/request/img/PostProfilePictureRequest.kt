package com.team_ia.data.remote.request.img

import android.media.Image
import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.PostProfilePictureParam

data class PostProfilePictureRequest(
    @SerializedName("multipartFiles")
    val multipartFiles: Image
)

fun PostProfilePictureParam.toRequest() = PostProfilePictureRequest(
    multipartFiles = multipartFiles
)