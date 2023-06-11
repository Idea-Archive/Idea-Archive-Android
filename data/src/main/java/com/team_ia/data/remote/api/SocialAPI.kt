package com.team_ia.data.remote.api

import retrofit2.http.POST

interface SocialAPI {

    @POST("/google/login")
    suspend fun googleLogin(
        
    )

}