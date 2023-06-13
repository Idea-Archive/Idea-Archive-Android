package com.team_ia.domain.repository

import com.team_ia.domain.entity.SocialLoginEntity

interface SocialRepository {
    suspend fun fetchGoogleAuthInfo(authCode: String): Result<SocialLoginEntity>

}