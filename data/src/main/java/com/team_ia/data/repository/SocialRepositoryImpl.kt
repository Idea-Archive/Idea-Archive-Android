package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.SocialDataSource
import com.team_ia.domain.repository.SocialRepository
import javax.inject.Inject

class SocialRepositoryImpl @Inject constructor(
    private val socialDataSource: SocialDataSource
) : SocialRepository {
}