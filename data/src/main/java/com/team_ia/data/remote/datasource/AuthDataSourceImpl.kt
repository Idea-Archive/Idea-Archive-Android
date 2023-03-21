package com.team_ia.data.remote.datasource

import com.team_ia.data.remote.api.AuthApi
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthDatasource {
}