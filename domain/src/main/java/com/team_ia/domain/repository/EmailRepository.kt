package com.team_ia.domain.repository

import com.team_ia.domain.param.SendVerificationCodeParam

interface EmailRepository {
    suspend fun sendVerificationCode(param: SendVerificationCodeParam)
}