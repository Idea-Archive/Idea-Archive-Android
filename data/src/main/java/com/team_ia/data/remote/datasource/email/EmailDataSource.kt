package com.team_ia.data.remote.datasource.email

import com.team_ia.data.remote.request.email.SendVerificationCodeRequest

interface EmailDataSource {
    suspend fun sendVerificationCode(sendVerificationCodeRequest: SendVerificationCodeRequest)
}