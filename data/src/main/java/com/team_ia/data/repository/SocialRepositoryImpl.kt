package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.social.SocialDataSource
import com.team_ia.data.remote.response.social.SocialLoginResponse
import com.team_ia.domain.repository.SocialRepository
import javax.inject.Inject

class SocialRepositoryImpl @Inject constructor(
    private val socialDataSource: SocialDataSource
) : SocialRepository {
    override suspend fun fetchGoogleAuthInfo(authCode: String): Result<SocialLoginResponse> {

}