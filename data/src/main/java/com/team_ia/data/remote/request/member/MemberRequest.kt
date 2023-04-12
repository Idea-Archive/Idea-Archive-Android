package com.team_ia.data.remote.request.member

import com.google.gson.annotations.SerializedName

data class MemberRequest(
    @SerializedName("email")
    val email: String
)
