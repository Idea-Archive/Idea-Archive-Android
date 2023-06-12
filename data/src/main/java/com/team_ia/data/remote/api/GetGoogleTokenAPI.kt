package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.auth.LoginGoogleRequest
import com.team_ia.data.remote.response.auth.LoginGoogleResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface GetGoogleTokenAPI {
    @POST("oauth2/v4/token")
    suspend fun fetchGoogleAuthInfo(
        @Body request: LoginGoogleRequest
    ): Response<LoginGoogleResponse>?
}