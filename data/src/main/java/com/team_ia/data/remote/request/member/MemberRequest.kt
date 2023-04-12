package com.team_ia.data.remote.request.member

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.MemberParam

data class MemberRequest(
    @SerializedName("email")
    val email: String
)

fun MemberParam.toRequest() = MemberRequest(
    email = email
)