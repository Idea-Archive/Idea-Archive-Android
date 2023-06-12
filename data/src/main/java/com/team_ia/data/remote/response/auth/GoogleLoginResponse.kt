package com.team_ia.data.remote.response.auth

import com.team_ia.domain.entity.GoogleLoginEntity

data class GoogleLoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: Int
)

fun GoogleLoginResponse.toEntity() = GoogleLoginEntity(
    accessToken = accessToken,
    refreshToken = refreshToken,
    expiredAt = expiredAt
)