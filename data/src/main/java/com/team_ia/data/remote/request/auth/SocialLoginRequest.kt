package com.team_ia.data.remote.request.auth

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.SocialLoginParam

data class SocialLoginRequest(
    @SerializedName("code")
    private val code: String
)

fun SocialLoginParam.toRequest() = SocialLoginRequest(
    code = code
)

