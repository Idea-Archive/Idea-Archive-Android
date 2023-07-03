package com.team_ia.data.remote.response.member

import com.google.gson.annotations.SerializedName
import com.team_ia.data.remote.model.PostModel
import com.team_ia.data.remote.model.toEntity
import com.team_ia.domain.entity.MemberEntity

data class MemberResponse(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("profileImg")
    val profileImg: String?
)

fun MemberResponse.toEntity() = MemberEntity(
    email = email,
    name = name,
    profileImg = profileImg
)