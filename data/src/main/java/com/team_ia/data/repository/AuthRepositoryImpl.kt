package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.AuthDatasource
import com.team_ia.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDatasource: AuthDatasource
) : AuthRepository {
}