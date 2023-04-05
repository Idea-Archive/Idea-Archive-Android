package com.team_ia.data.remote.datasource

import com.team_ia.data.remote.api.ImgAPI
import javax.inject.Inject

class ImgDataSourceImpl @Inject constructor(
    private val imgAPI: ImgAPI
) : ImgDataSource {
}