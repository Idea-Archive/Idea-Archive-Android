package com.team_ia.domain.entity

data class LoginEntity(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: String
)
