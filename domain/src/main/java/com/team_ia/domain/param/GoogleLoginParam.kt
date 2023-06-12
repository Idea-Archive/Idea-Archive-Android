package com.team_ia.domain.param

data class GoogleLoginParam(
    val grantType: String,

    val clientId: String,

    val clientSecret: String,

    val redirectUri: String,

    val code: String
)
