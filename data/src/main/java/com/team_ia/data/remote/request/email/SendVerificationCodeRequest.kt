package com.team_ia.data.remote.request.email

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.SendVerificationCodeParam

data class SendVerificationCodeRequest (
    @SerializedName("email")
    val email: String
)

fun SendVerificationCodeParam.toRequest() = SendVerificationCodeRequest(
    email = email
)