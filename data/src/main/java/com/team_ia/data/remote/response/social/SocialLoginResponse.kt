package com.team_ia.data.remote.response.social

import com.team_ia.domain.entity.SocialLoginEntity

data class SocialLoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: Int
)

fun SocialLoginResponse.toEntity() = SocialLoginEntity(
    accessToken = accessToken,
    refreshToken = refreshToken,
    expiredAt = expiredAt
)