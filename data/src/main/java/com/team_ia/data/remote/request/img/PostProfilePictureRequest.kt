package com.team_ia.data.remote.request.img

import android.media.Image
import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.PostProfilePictureParam
import okhttp3.MultipartBody

data class PostProfilePictureRequest(
    @SerializedName("multipartFiles")
    val multipartFiles: MultipartBody.Part
)

fun PostProfilePictureParam.toRequest() = PostProfilePictureRequest(
    multipartFiles = multipartFiles
)