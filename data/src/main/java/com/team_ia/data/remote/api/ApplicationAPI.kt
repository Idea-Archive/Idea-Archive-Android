package com.team_ia.data.remote.api

import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Path

interface ApplicationAPI {

    @POST("/application/{postId}")
    suspend fun applicationPost(
        @Path("postId") postId: Long
    ): Response<Unit>
}