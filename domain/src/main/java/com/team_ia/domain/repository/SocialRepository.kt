package com.team_ia.domain.repository

import com.team_ia.domain.entity.SocialLoginEntity
import com.team_ia.domain.param.SocialLoginParam

interface SocialRepository {

    suspend fun socialLogin(socialLoginParam: SocialLoginParam):SocialLoginEntity
    suspend fun logout()
    suspend fun saveToken(
        accessToken: String,
        refreshToken: String,
        expiredAt: String
    )
}