package com.team_ia.domain.entity

data class GoogleLoginEntity (
    val accessToken: String,
    val expiresIn: Int,
    val scope: String,
    val tokenType: String,
    val idToken: String
)