package com.team_ia.data.remote.request.auth

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.GoogleLoginParam

data class LoginGoogleRequest(
    @SerializedName("code")
    private val code: String
)

fun GoogleLoginParam.toRequest() = LoginGoogleRequest(
    code = code
)

