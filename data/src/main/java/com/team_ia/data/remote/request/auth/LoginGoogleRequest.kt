package com.team_ia.data.remote.request.auth

import com.google.gson.annotations.SerializedName

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
