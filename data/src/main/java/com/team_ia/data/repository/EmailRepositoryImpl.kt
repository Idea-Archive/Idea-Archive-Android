package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.email.EmailDataSource
import com.team_ia.data.remote.request.email.toRequest
import com.team_ia.domain.param.SendVerificationCodeParam
import com.team_ia.domain.repository.EmailRepository
import javax.inject.Inject

class EmailRepositoryImpl @Inject constructor(
    private val emailDataSource: EmailDataSource
) : EmailRepository {
    override suspend fun sendVerificationCode(param: SendVerificationCodeParam) =
        emailDataSource.sendVerificationCode(param.toRequest())

    override suspend fun checkVerificationCode(email: String, authKey: Int) =
        emailDataSource.checkVerificationCode(email, authKey)

}