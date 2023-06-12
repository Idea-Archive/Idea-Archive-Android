package com.team_ia.domain.entity

data class GoogleLoginEntity (
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: Int
)