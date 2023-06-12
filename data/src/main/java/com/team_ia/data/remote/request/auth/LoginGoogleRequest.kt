package com.team_ia.data.remote.request.auth

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.GoogleLoginParam

data class LoginGoogleRequest(
    @SerializedName("grantType")
    private val grantType: String,

    @SerializedName("clientId")
    private val clientId: String,

    @SerializedName("clientSecret")
    private val clientSecret: String,

    @SerializedName("redirectUri")
    private val redirectUri: String,

    @SerializedName("code")
    private val code: String

)

fun GoogleLoginParam.toRequest() = LoginGoogleRequest(
    grantType = grantType,
    clientId = clientId,
    clientSecret = clientSecret,
    redirectUri = redirectUri,
    code = code
)

