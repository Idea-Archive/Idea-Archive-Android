package com.team_ia.data.remote.datasource

import com.team_ia.data.remote.api.AdminAPI
import javax.inject.Inject

class AdminDataSourceImpl @Inject constructor(
    private val adminAPI: AdminAPI
) : AdminDataSource {
}