package com.team_ia.data.remote.request.auth

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.LoginParam

data class LoginRequest (
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
    )

fun LoginParam.toRequest() = LoginRequest(
    email = email,
    password = password
)
