package com.team_ia.data.remote.datasource.admin

import com.team_ia.data.remote.api.AdminAPI
import com.team_ia.data.remote.datasource.admin.AdminDataSource
import javax.inject.Inject

class AdminDataSourceImpl @Inject constructor(
    private val adminAPI: AdminAPI
) : AdminDataSource {
}