package com.team_ia.data.remote.request.img

import android.media.Image
import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.ChangeProfilePictureParam
import okhttp3.MultipartBody

data class ChangeProfilePictureRequest(
    @SerializedName("multipartFiles")
    val multipartFiles: MultipartBody.Part
)

fun ChangeProfilePictureParam.toRequest() = ChangeProfilePictureRequest(
    multipartFiles = multipartFiles
)