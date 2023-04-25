package com.team_ia.data.remote.request.member

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.ChangeNickNameParam

data class ChangeNickNameRequest(
    @SerializedName("newNickname")
    val newNickname: String
)

fun ChangeNickNameParam.toRequest() = ChangeNickNameRequest(
    newNickname = newNickname
)