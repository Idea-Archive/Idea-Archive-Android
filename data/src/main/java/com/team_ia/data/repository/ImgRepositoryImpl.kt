package com.team_ia.data.repository

import com.team_ia.data.remote.datasource.ImgDataSource
import com.team_ia.domain.repository.ImgRepository
import javax.inject.Inject

class ImgRepositoryImpl @Inject constructor(
    private val imgDataSource: ImgDataSource
) : ImgRepository {
}