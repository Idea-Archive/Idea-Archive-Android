package com.team_ia.data.remote.request.member

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.FindPasswordParam

data class FindPasswordRequest(
    @SerializedName("password")
    val password: String,
    @SerializedName("checkPassword")
    val checkPassword: String
)

fun FindPasswordParam.toRequest() = FindPasswordRequest(
    password = password,
    checkPassword = checkPassword
)
