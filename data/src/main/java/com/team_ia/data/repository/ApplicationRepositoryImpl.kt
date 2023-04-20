package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.application.ApplicationDataSource
import com.team_ia.domain.repository.ApplicationRepository
import javax.inject.Inject

class ApplicationRepositoryImpl @Inject constructor(
    private val applicationDataSource: ApplicationDataSource
) : ApplicationRepository {
}