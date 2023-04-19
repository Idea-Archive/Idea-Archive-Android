package com.team_ia.data.remote.response.auth

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.entity.LoginEntity

data class LoginResponse(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String,
    @SerializedName("expiredAt")
    val expiredAt: String
)

fun LoginEntity.toEntity() = LoginResponse(
    accessToken = accessToken,
    refreshToken = refreshToken,
    expiredAt = expiredAt
)