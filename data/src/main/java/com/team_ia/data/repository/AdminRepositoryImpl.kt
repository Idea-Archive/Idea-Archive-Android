package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.admin.AdminDataSource
import com.team_ia.domain.repository.AdminRepository
import javax.inject.Inject

class AdminRepositoryImpl @Inject constructor(
    private val adminDataSource: AdminDataSource
) : AdminRepository {
}