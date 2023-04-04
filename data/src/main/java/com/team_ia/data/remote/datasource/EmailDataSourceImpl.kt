package com.team_ia.data.remote.datasource

import com.team_ia.data.remote.api.EmailAPI
import javax.inject.Inject

class EmailDataSourceImpl @Inject constructor(
    private val emailAPI: EmailAPI
) : EmailDataSource {
}