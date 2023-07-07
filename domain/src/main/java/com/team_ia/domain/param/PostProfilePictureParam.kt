package com.team_ia.domain.param

import okhttp3.MultipartBody

data class PostProfilePictureParam(
    val multipartFiles: MultipartBody.Part
)