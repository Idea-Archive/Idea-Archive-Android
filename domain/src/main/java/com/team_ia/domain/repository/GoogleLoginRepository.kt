package com.team_ia.domain.repository

import com.team_ia.domain.entity.GoogleLoginEntity

interface GoogleLoginRepository {
    suspend fun fetchGoogleAuthInfo(authCode: String): Result<GoogleLoginEntity>
}