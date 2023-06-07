package com.team_ia.data.remote.api

import com.team_ia.data.remote.request.email.SendVerificationCodeRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface EmailAPI {

    @POST("/email/send")
    suspend fun sendVerificationCode(
        @Body sendVerificationCodeRequest: SendVerificationCodeRequest
    ): Response<Unit>
}