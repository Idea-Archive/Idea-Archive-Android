package com.team_ia.data.remote.datasource

import com.team_ia.data.remote.api.ApplicationAPI
import javax.inject.Inject

class ApplicationDataSourceImpl @Inject constructor(
    applicationAPI: ApplicationAPI
) : ApplicationDataSource {
}