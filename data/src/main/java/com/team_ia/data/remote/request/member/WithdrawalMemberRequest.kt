package com.team_ia.data.remote.request.member

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.WithdrawalMemberParam

data class WithdrawalMemberRequest (
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)

fun WithdrawalMemberParam.toRequest() = WithdrawalMemberRequest(
    email = email,
    password = password
)