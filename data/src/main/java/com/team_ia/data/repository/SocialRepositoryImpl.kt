package com.team_ia.data.repository

import com.team_ia.data.local.datasource.LocalAuthDataSource
import com.team_ia.data.remote.datasource.social.SocialDataSource
import com.team_ia.data.remote.request.auth.toRequest
import com.team_ia.data.remote.response.auth.toEntity
import com.team_ia.domain.entity.LoginEntity
import com.team_ia.domain.param.SocialLoginParam
import com.team_ia.domain.repository.SocialRepository
import javax.inject.Inject

class SocialRepositoryImpl @Inject constructor(
    private val socialDataSource: SocialDataSource,
    private val localAuthDataSource: LocalAuthDataSource
) : SocialRepository {
    override suspend fun socialLogin(param: SocialLoginParam): LoginEntity =
        socialDataSource.socialLogin(param.toRequest()).toEntity()

    override suspend fun logout() {
        socialDataSource.logout()
    }

    override suspend fun saveToken(accessToken: String, refreshToken: String, expiredAt: String) {
        localAuthDataSource.saveToken(accessToken, refreshToken, expiredAt)
    }
    }
