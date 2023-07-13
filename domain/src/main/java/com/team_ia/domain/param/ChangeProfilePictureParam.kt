package com.team_ia.domain.param

import okhttp3.MultipartBody

data class ChangeProfilePictureParam(
    val multipartFiles: MultipartBody.Part
)