package com.team_ia.data.remote.request.auth

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.SignupParam

data class SignupRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("name")
    val name: String
)

fun SignupParam.toRequest() = SignupRequest(
    email = email,
    password = password,
    name = name
)