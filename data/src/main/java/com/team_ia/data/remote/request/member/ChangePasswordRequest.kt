package com.team_ia.data.remote.request.member

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.PasswordParam

data class ChangePasswordRequest(
    @SerializedName("currentPassword")
    val currentPassword: String,
    @SerializedName("newPassword")
    val newPassword: String
)

fun PasswordParam.toRequest() = ChangePasswordRequest(
    currentPassword = currentPassword,
    newPassword = newPassword
)



