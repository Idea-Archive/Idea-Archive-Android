package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.email.EmailDataSource
import com.team_ia.domain.repository.EmailRepository
import javax.inject.Inject

class EmailRepositoryImpl @Inject constructor(
    private val emailDataSource: EmailDataSource
) : EmailRepository {
}