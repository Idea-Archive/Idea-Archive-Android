package com.team_ia.data.remote.request.member

import com.team_ia.domain.param.PasswordParam

data class ChangePasswordRequest(
    val currentPassword: String,
    val newPassword: String
)

fun PasswordParam.toRequest() = ChangePasswordRequest(
    currentPassword = currentPassword,
    newPassword = newPassword
)