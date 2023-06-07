package com.team_ia.data.remote.datasource.email

import com.team_ia.data.remote.api.EmailAPI
import com.team_ia.data.remote.request.email.SendVerificationCodeRequest
import com.team_ia.data.utils.IAApiHandler
import javax.inject.Inject

class EmailDataSourceImpl @Inject constructor(
    private val emailAPI: EmailAPI
) : EmailDataSource {
    override suspend fun sendVerificationCode(sendVerificationCodeRequest: SendVerificationCodeRequest) {
        return IAApiHandler<Unit>()
            .httpRequest { emailAPI.sendVerificationCode(sendVerificationCodeRequest) }
            .sendRequest()
    }
}