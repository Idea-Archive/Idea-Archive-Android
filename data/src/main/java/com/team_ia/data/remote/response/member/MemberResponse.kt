package com.team_ia.data.remote.response.member

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.entity.MemberEntity

data class MemberResponse(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("profileImg")
    val profileImg: String
)

fun MemberResponse.toEntity() = MemberEntity(
    email = email,
    password = password,
    profileImg = profileImg
)