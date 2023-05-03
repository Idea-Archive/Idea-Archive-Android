package com.team_ia.data.remote.api

import com.team_ia.data.remote.response.application.GetApplicantResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApplicationAPI {

    @POST("/application/{postId}")
    suspend fun applicationPost(
        @Path("postId") postId: Long
    ): Response<Unit>

    @GET("/application/{postId}")
    suspend fun getApplicant(
        @Path("postId") postId: Long
    ): GetApplicantResponse
}