package com.team_ia.domain.entity

data class SocialLoginEntity (
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: Int
)