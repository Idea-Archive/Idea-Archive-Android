package com.team_ia.data.remote.datasource

import com.team_ia.data.remote.api.AuthAPI
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authApi: AuthAPI
) : AuthDatasource {
}