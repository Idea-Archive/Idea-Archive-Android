package com.team_ia.data.remote.response.auth

import com.team_ia.domain.entity.GoogleLoginEntity

data class LoginGoogleResponse(
    var accessToken: String = "",
    var expiresIn: Int = 0,
    var scope: String = "",
    var tokenType: String = "",
    var idToken: String = "",
)

fun LoginGoogleResponse.toEntity() = GoogleLoginEntity(
    accessToken = accessToken,
    expiresIn = expiresIn,
    scope = scope,
    tokenType = tokenType,
    idToken = idToken
)